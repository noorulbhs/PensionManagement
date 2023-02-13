package com.fse0.microservice.processpension;

import com.fse0.microservice.processpension.controller.ProcessPensionController;
import com.fse0.microservice.processpension.dto.PensionerResponseBody;
import com.fse0.microservice.processpension.pensioner.PensionDetail;
import com.fse0.microservice.processpension.pensioner.PensionerDetail;

import com.fse0.microservice.processpension.repo.PensionerDetailRepo;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private ProcessPensionController processPensionController;
    @Autowired
    private MockMvc mockMvc;
//
//    @Test
//    void check(){
//        System.out.println("Checkinggg");
//
//    }


    @Test
    void getPensionerProcess() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("adhaarNumber", "10001");
        JSONObject jo = new JSONObject(map);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PensionerResponseBody<PensionerDetail> responseBody = new PensionerResponseBody<>();
        PensionerDetail pensioner = new PensionerDetail(10000015,"Starla",
                LocalDate.parse("03/10/2013", formatter),"Adore",
                BigDecimal.ONE,BigDecimal.ONE,"Group","Testing Bank",
                863236,"public");
        PensionDetail pensionerProcess = new PensionDetail();
        MvcResult result = mockMvc.perform(post("/process-pension")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jo.toString()))
                .andExpect(status().isOk())
                .andReturn();
        Assert.notNull(result);
    }

    @Test
    void getPensionerProcesssave() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PensionerDetailRepo processPensionSave = new PensionerDetailRepo();
        PensionerDetail pensioner = new PensionerDetail(10001,"Starla",
                LocalDate.parse("03/10/2013", formatter),"Adore",
                BigDecimal.ONE,BigDecimal.ONE,"Group","BOB",12345,"Public");
        //ProcessPensionSave processPensionSave = new ProcessPensionSave(10000015,"Starla", LocalDate.parse("03/16/2013", formatter),"Adore",30421.66216,878,"Group","Testing Bank",863237976L,"public", 100.00, 100.00);
        mockMvc.perform(get("/process-pension/10001/save"))
                .andDo(print())
                .andExpect(status().isOk());
        Assertions.assertNotNull(processPensionSave);
    }

}
