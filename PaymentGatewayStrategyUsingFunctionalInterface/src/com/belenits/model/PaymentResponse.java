package com.belenits.model;

public class PaymentResponse {

    private String transactionId;
    private String paymentStatus;
    private Double finalAmount;
    private String message;

    public PaymentResponse(String transactionId, String paymentStatus, Double finalAmount, String message) {
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.finalAmount = finalAmount;
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
