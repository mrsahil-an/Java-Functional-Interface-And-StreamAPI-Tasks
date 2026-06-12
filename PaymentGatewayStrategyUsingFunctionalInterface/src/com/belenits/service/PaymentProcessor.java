package com.belenits.service;

import com.belenits.functional.PaymentGateway;
import com.belenits.model.PaymentRequest;
import com.belenits.model.PaymentResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PaymentProcessor {

    private final Map<String, PaymentGateway> gateways =
            new HashMap<>();

    public PaymentProcessor() {

        PaymentGateway upiGateway = request ->
                createResponse(request, "UPI Payment Successful");

        PaymentGateway cardGateway = request ->
                createResponse(request, "Credit Card Payment Successful");

        PaymentGateway netBankingGateway = request ->
                createResponse(request, "Net Banking Payment Successful");

        PaymentGateway walletGateway = request ->
                createResponse(request, "Wallet Payment Successful");

        gateways.put("UPI", upiGateway);
        gateways.put("CARD", cardGateway);
        gateways.put("NETBANKING", netBankingGateway);
        gateways.put("WALLET", walletGateway);
    }

    public PaymentResponse processPayment(PaymentRequest request) {

        Predicate<PaymentRequest> amountValidator =
                payment -> payment.getAmount() != null
                        && payment.getAmount() > 0;

        if (!amountValidator.test(request)) {

            return new PaymentResponse(
                    null,
                    "FAILED",
                    0.0,
                    "Invalid Amount"
            );
        }

        Function<PaymentRequest, PaymentRequest> couponProcessor =
                payment -> {

                    if ("COURSE10".equalsIgnoreCase(
                            payment.getCouponCode())) {

                        payment.setAmount(
                                payment.getAmount() * 0.90
                        );
                    }

                    return payment;
                };

        request = couponProcessor.apply(request);

        request.setAmount(request.getAmount() + 20);

        PaymentGateway gateway =
                gateways.get(request.getPaymentMode());

        if (gateway == null) {

            return new PaymentResponse(
                    null,
                    "FAILED",
                    request.getAmount(),
                    "Unsupported Payment Mode"
            );
        }

        return gateway.pay(request);
    }

    private PaymentResponse createResponse(
            PaymentRequest request,
            String message) {

        Supplier<String> transactionSupplier =
                () -> "TXN"
                        + UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 10)
                        .toUpperCase();

        return new PaymentResponse(
                transactionSupplier.get(),
                "SUCCESS",
                request.getAmount(),
                message
        );
    }
}