package com.fse0.microservice.processpension.repo;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


import javax.persistence.Entity;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetailRepo {
    @Id
    private Integer adhaarNumber;
    private String name;
    private LocalDate dateOfBirth;
    private String panNumber;
    private BigDecimal salaryEarned;
    private BigDecimal allowances;
    private String sumOfFamilyPension;
    private String bankName;
    private int accountNumber;
    private String bankType;
    private BigDecimal pensionAmount;
    private BigDecimal bankServiceCharge;

}