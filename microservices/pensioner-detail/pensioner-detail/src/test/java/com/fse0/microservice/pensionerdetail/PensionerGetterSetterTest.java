package com.fse0.microservice.pensionerdetail;

import com.fse0.microservice.pensionerdetail.pensioner.PensionerDetail;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PensionerGetterSetterTest {

    @Test
    public void testSetAdhaarNumber() {
        int adhaarNumber = 1000;
        PensionerDetail instance = new PensionerDetail();
        instance.setAdhaarNumber(adhaarNumber);
        assertEquals(instance.getAdhaarNumber(), adhaarNumber);
    }

    @Test
    public void testSetName() {
        String name = "ABC";
        PensionerDetail instance = new PensionerDetail();
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }

    @Test
    public void testDOB() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("10/10/1990",formatter);
        PensionerDetail instance = new PensionerDetail();
        instance.setDateOfBirth(date);
        assertEquals(instance.getDateOfBirth(), date);
    }

    @Test
    public void testPanNumber() {
        String panNumber = "ABC123";
        PensionerDetail instance = new PensionerDetail();
        instance.setPanNumber(panNumber);

        assertEquals(instance.getPanNumber(), panNumber);
    }

    @Test
    public void testSalaryEarned() {
        BigDecimal salary = BigDecimal.ONE;
        PensionerDetail instance = new PensionerDetail();
        instance.setSalaryEarned(salary);
        assertEquals(instance.getSalaryEarned(), salary);
    }

    @Test
    public void testAllowances() {
        BigDecimal allowances = BigDecimal.ONE;
        PensionerDetail instance = new PensionerDetail();
        instance.setAllowances(allowances);
        assertEquals(instance.getAllowances(), allowances);
    }

    @Test
    public void testSelfOrFamilyPension() {
        String selfOrFamily = "Self";
        PensionerDetail instance = new PensionerDetail();
        instance.setSelfOrFamilyPension(selfOrFamily);
        assertEquals(instance.getSelfOrFamilyPension(), selfOrFamily);
    }

    @Test
    public void testBankName() {
        String bankName = "HDFC";
        PensionerDetail instance = new PensionerDetail();
        instance.setBankName(bankName);
        assertEquals(instance.getBankName(), bankName);
    }

    @Test
    public void testAccountNumber() {
        int accountNumber = 123;
        PensionerDetail instance = new PensionerDetail();
        instance.setAccountNumber(accountNumber);
        assertEquals(instance.getAccountNumber(), accountNumber);
    }

    @Test
    public void testBankType() {
        String bankType = "Public";
        PensionerDetail instance = new PensionerDetail();
        instance.setBankType(bankType);
        assertEquals(instance.getBankType(), bankType);
    }
}
