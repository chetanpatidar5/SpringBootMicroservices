package com.exchange.springcloud.orderservice.controller;

import com.exchange.springcloud.orderservice.common.Payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service")
public interface PaymentServiceProxy {

    @PostMapping("/payment/doPayment")
    public Payment doPayment(@RequestBody Payment payment);

}
