package com.exchange.springcloud.paymentservice.controller;


import com.exchange.springcloud.paymentservice.entity.Payment;
import com.exchange.springcloud.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        return paymentService.doPayment(payment);
    }

    public String paymentProcessing() {

        //api should be third party gateway
        return new Random().nextBoolean()?"success":"false";
    }
    @GetMapping("/{orderId}")
    public Payment getOrderId(@PathVariable int orderId){

        return paymentService.findByOrderId(orderId);

    }
}
