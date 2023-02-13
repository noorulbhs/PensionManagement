package com.fse0.microservice.processpension.controller;

import com.fse0.microservice.processpension.dto.PensionerResponseBody;
import com.fse0.microservice.processpension.helper.ProcessPensionRequest;
import com.fse0.microservice.processpension.pensioner.PensionDetail;
import com.fse0.microservice.processpension.pensioner.PensionerDetail;
import com.fse0.microservice.processpension.proxy.PensionDetailProxy;
import com.fse0.microservice.processpension.repo.PensionerDetailRepo;
import com.fse0.microservice.processpension.repo.PensionerDetailRepositoryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
public class ProcessPensionController {

    @Autowired
    private PensionDetailProxy pensionDetailProxy;

    @Autowired
    private PensionerDetailRepositoryManager pensionerDetailRepositoryManager;

    private PensionerResponseBody<PensionerDetail> response;

    private BigDecimal pensionAmount;
    private BigDecimal bankServiceCharge;


    @PostMapping("/process-pension")
    public ResponseEntity<?> retriveProcessPensionDetails(/*@RequestHeader("Authorization") String token,*/ @RequestBody ProcessPensionRequest processPensionRequest) throws Exception {
       System.out.println("Pensioner From Post Process pension");
        try {
            response = pensionDetailProxy.retrievePensionDetails(processPensionRequest.getAdhaarNumber());
            PensionerResponseBody<PensionDetail> pensionerProcessPensionerResponseBody = new PensionerResponseBody<>();
            System.out.println("adhaar number "+processPensionRequest.getAdhaarNumber());
            System.out.println("Response "+response.getContent());
            if(response.getContent()!=null){
                PensionerDetail pensioner = response.getContent();
                System.out.println("pensioner details are " + pensioner);
                PensionDetail pensionerProcess = new PensionDetail(calculatePension(pensioner.getSelfOrFamilyPension(),pensioner.getSalaryEarned(), pensioner.getAllowances()),
                        BankServiceCharge(pensioner.getBankType())
                );
                pensionerProcessPensionerResponseBody.setContent(pensionerProcess);
            }

            pensionerProcessPensionerResponseBody.setError_msg(response.getError_msg());
            return ResponseEntity.ok(pensionerProcessPensionerResponseBody);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
   }


    @GetMapping("/process-pension/{adhaarNumber}/save")
    public PensionerResponseBody<?> save(@PathVariable Integer adhaarNumber){
        PensionerResponseBody<PensionDetail> save_message = new PensionerResponseBody<>();
       try{
           PensionerDetail processPensionerDetail = response.getContent();
            PensionerDetailRepo pensionerDetailRepo=new PensionerDetailRepo(processPensionerDetail.getAdhaarNumber(),
                    processPensionerDetail.getName(),processPensionerDetail.getDateOfBirth(),
                    processPensionerDetail.getPanNumber(),processPensionerDetail.getSalaryEarned(),
                    processPensionerDetail.getAllowances(),processPensionerDetail.getSelfOrFamilyPension(),
                    processPensionerDetail.getBankName(),processPensionerDetail.getAccountNumber()
                    ,processPensionerDetail.getBankType(),pensionAmount,bankServiceCharge);
            pensionerDetailRepositoryManager.save(pensionerDetailRepo);

           pensionerDetailRepositoryManager.save(pensionerDetailRepo);
           save_message.setError_msg("Successfully Saved");
       } catch (Exception e) {
           save_message.setError_msg("Something Went Wrong");
        }
       return  save_message;
    }


    private BigDecimal calculatePension(String pensionType, BigDecimal salary, BigDecimal allowance){
        BigDecimal pensionAmount;
        if(pensionType.equals("self")){
            pensionAmount=salary.multiply(BigDecimal.valueOf(0.8)).add(allowance);
        }else{
            pensionAmount=salary.multiply(BigDecimal.valueOf(0.5)).add(allowance);
        }


        return pensionAmount;
    }

    public BigDecimal BankServiceCharge(String bankType){
        BigDecimal bankServiceCharge;
        if(bankType.equals("Public")){
            bankServiceCharge=BigDecimal.valueOf(500);
        }else{
            bankServiceCharge=BigDecimal.valueOf(550);
        }
        return bankServiceCharge;
    }
}
