package com.exchange.springcloud.orderservice.repository;


import com.exchange.springcloud.orderservice.common.Payment;
import com.exchange.springcloud.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {





}
