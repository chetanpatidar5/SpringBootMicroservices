package com.exchange.springcloud.paymentservice.repository;


import com.exchange.springcloud.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    Payment findByOrderId(int orderId);

}
