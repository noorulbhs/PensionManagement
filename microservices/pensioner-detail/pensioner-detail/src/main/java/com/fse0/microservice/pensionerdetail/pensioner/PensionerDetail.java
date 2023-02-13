package com.fse0.microservice.pensionerdetail.pensioner;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PensionerDetail {

    private Integer adhaarNumber;
    private String name;
    private LocalDate dateOfBirth;
    private String panNumber;
    private BigDecimal salaryEarned;
    private BigDecimal allowances;
    private String selfOrFamilyPension;
    private String bankName;
    private int accountNumber;
    private String bankType;


}
