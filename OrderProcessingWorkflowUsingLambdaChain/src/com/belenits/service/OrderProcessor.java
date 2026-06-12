package com.belenits.service;

import com.belenits.model.Order;

@FunctionalInterface
public interface OrderProcessor {

    Order process(Order order);

    default OrderProcessor andThen(OrderProcessor nextProcessor) {
        return order -> nextProcessor.process(this.process(order));

    }
}