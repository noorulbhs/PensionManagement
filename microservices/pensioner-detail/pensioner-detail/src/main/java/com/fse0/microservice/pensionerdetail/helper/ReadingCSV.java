package com.fse0.microservice.pensionerdetail.helper;

import com.fse0.microservice.pensionerdetail.pensioner.PensionerDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import java.io.*;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReadingCSV {

    @Bean
    public Map<Integer, List<PensionerDetail>> readingCSv() throws IOException {
        String line;
        Map<Integer, List<PensionerDetail>> pensionerDetail = new HashMap<>();
        List<PensionerDetail> detail;
        PensionerDetail pensioner;
        Resource resource = new ClassPathResource("PensionerDetail.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));


        while ((line = br.readLine()) != null)
        {
            detail = new ArrayList<>();
            String[] data = line.split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            pensioner = new PensionerDetail(Integer.parseInt(data[0]),data[1],
                    LocalDate.parse(data[2], formatter),data[3], BigDecimal.valueOf(Double.parseDouble(data[4])),
                    BigDecimal.valueOf(Double.parseDouble(data[5])),data[6],data[7],Integer.parseInt(data[8]),data[9]);
            detail.add(pensioner);
            pensionerDetail.put(Integer.parseInt(data[0]),detail);

        }

        return  pensionerDetail;
    }


}
