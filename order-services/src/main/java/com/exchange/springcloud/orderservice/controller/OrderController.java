package com.exchange.springcloud.orderservice.controller;


import com.exchange.springcloud.orderservice.common.Payment;
import com.exchange.springcloud.orderservice.common.TransactionRequest;
import com.exchange.springcloud.orderservice.common.TransactionResponse;
import com.exchange.springcloud.orderservice.entity.Order;
import com.exchange.springcloud.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PaymentServiceProxy serviceProxy;
    @Autowired
    private OrderService orderService;


    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse = serviceProxy.doPayment(request.getPayment());

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
        orderService.saveOrder(request.getOrder());

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }

}

