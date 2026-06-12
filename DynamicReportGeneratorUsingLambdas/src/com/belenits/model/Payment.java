package com.belenits.model;

public class Payment {

    private int paymentId;
    private Student student;
    private double amount;
    private boolean paid;

    public Payment(int paymentId,
                   Student student,
                   double amount,
                   boolean paid) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.paid = paid;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }
}