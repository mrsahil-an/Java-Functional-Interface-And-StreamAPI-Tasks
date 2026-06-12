package com.belenits.service;

import com.belenits.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class LoanEligibilityService {

    private final List<ValidationRule> rules = new ArrayList<>();

    public LoanEligibilityService() {

        rules.add(new ValidationRule(
                customer -> customer.getAge() >= 21
                        && customer.getAge() <= 60,
                "Age should be between 21 and 60"));

        rules.add(new ValidationRule(
                customer -> customer.getMonthlySalary() >= 50000,
                "Monthly salary should be at least 50000"));

        rules.add(new ValidationRule(
                customer -> customer.getCreditScore() >= 750,
                "Credit score is below 750"));

        rules.add(new ValidationRule(
                customer -> customer.getExistingEmi()
                        < customer.getMonthlySalary() * 0.40,
                "Existing EMI exceeds 40% of salary"));

        rules.add(new ValidationRule(
                customer -> customer.getRequestedLoanAmount()
                        <= customer.getMonthlySalary() * 20,
                "Requested loan amount exceeds 20 times salary"));

        rules.add(new ValidationRule(
                customer ->
                        "SALARIED".equalsIgnoreCase(customer.getEmploymentType())
                                || "BUSINESS".equalsIgnoreCase(customer.getEmploymentType()),
                "Employment type should be SALARIED or BUSINESS"));
    }

    public boolean isEligible(Customer customer) {

        LoanRule combinedRule = c -> true;

        for (ValidationRule validationRule : rules) {
            combinedRule = combinedRule.and(validationRule.getRule());
        }

        return combinedRule.validate(customer);
    }

    public List<String> getFailureReasons(Customer customer) {

        List<String> failedReasons = new ArrayList<>();

        for (ValidationRule validationRule : rules) {

            if (!validationRule.getRule().validate(customer)) {
                failedReasons.add(validationRule.getErrorMessage());
            }
        }

        return failedReasons;
    }
}
