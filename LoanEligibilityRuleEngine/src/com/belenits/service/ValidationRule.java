package com.belenits.service;

public class ValidationRule {

    private LoanRule rule;
    private String errorMessage;

    public ValidationRule(LoanRule rule,
                          String errorMessage) {
        this.rule = rule;
        this.errorMessage = errorMessage;
    }

    public LoanRule getRule() {
        return rule;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}