package org.example.paymentservice.controller;

import org.example.paymentservice.consumer.CarRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRestController {
    @Autowired
    private CarRestConsumer consumer;

    @GetMapping("/payment/data")
    private String getPaymentData(){
        return "From payment service:"+consumer.getCartData();
    }
}

