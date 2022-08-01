package com.exchange.springcloud.paymentservice.service;

import com.exchange.springcloud.paymentservice.entity.Payment;
import com.exchange.springcloud.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){

        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }
    public Payment findByOrderId(int orderId){

        return paymentRepository.findByOrderId(orderId);
    }
}
