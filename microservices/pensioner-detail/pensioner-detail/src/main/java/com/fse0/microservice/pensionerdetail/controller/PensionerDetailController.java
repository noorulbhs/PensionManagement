package com.fse0.microservice.pensionerdetail.controller;

import com.fse0.microservice.pensionerdetail.dto.PensionerResponseBody;
import com.fse0.microservice.pensionerdetail.exception.ResourceNotFoundException;
import com.fse0.microservice.pensionerdetail.helper.ReadingCSV;
import com.fse0.microservice.pensionerdetail.pensioner.PensionerDetail;
//import com.fse0.microservice.pensionerdetail.proxy.AuthenticationProxy;
//import com.fse0.microservice.pensionerdetail.repository.PensionerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
//import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class PensionerDetailController {


    @Autowired
    ReadingCSV read;


    @GetMapping("/pensioner-detail/{adhaarNumber}")
    public PensionerResponseBody<?> retrievePensionersDetail(/*@RequestHeader("Authorization") String token,*/@PathVariable Integer adhaarNumber) throws IOException {
        PensionerResponseBody<PensionerDetail> pensionerResponseBody = new PensionerResponseBody<>();
        try{
            Map<Integer, List<PensionerDetail>> pensionerDetail = read.readingCSv();
            if(pensionerDetail.get(adhaarNumber)!=null){
                List<PensionerDetail> list = pensionerDetail.get(adhaarNumber);
                pensionerResponseBody.setContent(list.get(0));
            }
            else{
                throw new ResourceNotFoundException("Adhaar Number Does Not Exist");
            }
        }
        catch(Exception e){
            pensionerResponseBody.setError_msg(e.getMessage());
        }
        return pensionerResponseBody;
    }
}
