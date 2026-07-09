package com.example.paymentservice.controller;

import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/pay")
    public String pay() {

        return paymentService
                .processPayment();

    }
}