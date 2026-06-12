package com.belenits.main;

import com.belenits.model.Order;
import com.belenits.service.impl.OrderProcessors;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        Order order = new Order(
                "101",
                "John",
                List.of("Burger","Pizza"),
                350.5,
                "GENAI10"
        );

        double originalAmount = order.getTotalAmount();

        Order finalOrder =
                OrderProcessors.validateOrder
                        .andThen(OrderProcessors.applyCoupon)
                        .andThen(OrderProcessors.calculateGST)
                        .andThen(OrderProcessors.confirmPayment)
                        .andThen(OrderProcessors.assignDeliveryPartner)
                        .andThen(OrderProcessors.updateDeliveryStatus)
                        .process(order);

        System.out.println("Order ID: " + finalOrder.getOrderId());
        System.out.println("Original Amount: " + originalAmount);
        System.out.println("Coupon Applied: " + finalOrder.getCouponCode());
        System.out.println("GST Added: 18%");
        System.out.println("Final Amount: " +
                finalOrder.getTotalAmount().intValue());
        System.out.println("Payment Status: " +
                finalOrder.getPaymentStatus());
        System.out.println("Delivery Status: " +
                finalOrder.getDeliveryStatus());
    }
}

