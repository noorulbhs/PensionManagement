package com.fse0.microservice.pensionerdetail;

import com.fse0.microservice.pensionerdetail.controller.PensionerDetailController;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



@SpringBootTest
@AutoConfigureMockMvc
public class PensionDetailControllerTest {


    @Autowired
    private PensionerDetailController pensionerController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void retrievePensionersDetail() throws Exception{
        mockMvc.perform(get("/pensioner-detail/10001"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void retrievePensionersDetailNull() throws Exception{
        mockMvc.perform(get("/pensioner-detail/1000"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}