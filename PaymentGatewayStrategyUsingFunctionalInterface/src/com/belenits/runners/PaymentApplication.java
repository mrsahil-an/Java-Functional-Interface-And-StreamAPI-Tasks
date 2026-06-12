package com.belenits.runners;

import com.belenits.model.PaymentRequest;
import com.belenits.model.PaymentResponse;
import com.belenits.service.PaymentProcessor;

import java.util.Arrays;
import java.util.List;

public class PaymentApplication {

    public static void main(String[] args) {

        PaymentProcessor processor =
                new PaymentProcessor();

        List<PaymentRequest> requests =
                Arrays.asList(

                        new PaymentRequest(
                                "P101",
                                "Ravi",
                                25000.0,
                                "UPI",
                                "COURSE10",
                                null,
                                null
                        ),

                        new PaymentRequest(
                                "P102",
                                "Priya",
                                15000.0,
                                "CARD",
                                null,
                                null,
                                null
                        ),

                        new PaymentRequest(
                                "P103",
                                "Arjun",
                                30000.0,
                                "NETBANKING",
                                "COURSE10",
                                "HDFC",
                                null
                        ),

                        new PaymentRequest(
                                "P104",
                                "Sneha",
                                5000.0,
                                "WALLET",
                                null,
                                null,
                                "Paytm"
                        ),

                        new PaymentRequest(
                                "P105",
                                "Kiran",
                                -1000.0,
                                "UPI",
                                null,
                                null,
                                null
                        )
                );

        requests.stream()
                .map(processor::processPayment)
                .forEach(PaymentApplication::printResponse);
    }

    private static void printResponse(
            PaymentResponse response) {

        System.out.println(
                "\n==================================");

        System.out.println(
                "Transaction ID : "
                        + response.getTransactionId());

        System.out.println(
                "Payment Status : "
                        + response.getPaymentStatus());

        System.out.println(
                "Final Amount   : "
                        + response.getFinalAmount());

        System.out.println(
                "Message        : "
                        + response.getMessage());
    }
}
