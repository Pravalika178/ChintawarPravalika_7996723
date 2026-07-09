package com.example.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @CircuitBreaker(
            name = "paymentCB",
            fallbackMethod = "fallbackPayment"
    )
    public String processPayment() {

        throw new RuntimeException(
                "Third Party API Failed"
        );

    }

    public String fallbackPayment(
            Exception ex) {

        return "Payment Service Down. Please try again later.";
    }
}