package com.belenits.functional;

import com.belenits.model.PaymentRequest;
import com.belenits.model.PaymentResponse;

@FunctionalInterface
public interface PaymentGateway {

    PaymentResponse pay(PaymentRequest request);

}