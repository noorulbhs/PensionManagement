package com.fse0.microservice.processpension.pensioner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionDetail {
    BigDecimal pensionAmount;
    BigDecimal bankServiceCharge;


}
