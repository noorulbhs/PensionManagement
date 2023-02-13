package com.fse0.microservice.processpension.proxy;


import com.fse0.microservice.processpension.dto.PensionerResponseBody;

import com.fse0.microservice.processpension.pensioner.PensionerDetail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="pensioner-detail",url = "http://pensionerdetail844744-env.eba-8w2u7mxi.us-east-1.elasticbeanstalk.com")
public interface PensionDetailProxy {

    @GetMapping("/pensioner-detail/{adhaarNumber}")
    public PensionerResponseBody<PensionerDetail> retrievePensionDetails(/*@RequestHeader("Authorization") String token,*/@PathVariable Integer adhaarNumber);
}
