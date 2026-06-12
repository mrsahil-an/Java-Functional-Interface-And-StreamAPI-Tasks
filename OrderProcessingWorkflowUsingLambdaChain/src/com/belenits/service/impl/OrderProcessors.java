package com.belenits.service.impl;

import com.belenits.service.OrderProcessor;

public class OrderProcessors {

    public static OrderProcessor validateOrder = order -> {

        if (order.getOrderId() == null || order.getOrderId().isBlank()) {
            throw new IllegalArgumentException("Order ID can't be null");
        } else if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Items can't not be null");
        }
        return order;
    };

    public static OrderProcessor applyCoupon = order -> {

        if ("GENAI10".equalsIgnoreCase(order.getCouponCode())) {
            double discountAmount = order.getTotalAmount() - (order.getTotalAmount() * 0.10);
            order.setTotalAmount(discountAmount);
        }
        return order;
    };

    public static OrderProcessor calculateGST = order -> {
        if (order.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("Total amount can't be less then zero");
        } else {
            double gstAmount = order.getTotalAmount() + (order.getTotalAmount() * 0.18);
            order.setTotalAmount(gstAmount);
        }
        return order;
    };

    public static OrderProcessor confirmPayment = order -> {
        if (order.getTotalAmount() != 0 || !(order.getTotalAmount() < 0)) {
            order.setPaymentStatus("SUCCESS");
        }
        return order;
    };

    public static OrderProcessor assignDeliveryPartner = order -> {
        if ("SUCCESS".equalsIgnoreCase(order.getPaymentStatus())) {
            order.setDeliveryStatus("ASSIGNED");
        }
        return order;
    };

    public static OrderProcessor updateDeliveryStatus = order -> {
        if("ASSIGNED".equalsIgnoreCase(order.getDeliveryStatus()))
        {
            order.setDeliveryStatus("DELIVERED");
        }
        return order;
    };
}