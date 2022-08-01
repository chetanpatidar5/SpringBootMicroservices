package com.exchange.springcloud.orderservice.services;



import com.exchange.springcloud.orderservice.common.Payment;
import com.exchange.springcloud.orderservice.entity.Order;
import com.exchange.springcloud.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
  /*  @Autowired
    private RestTemplate template;*/

    public void saveOrder(Order request)  {
       /* String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9393/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
*/
        orderRepository.save(request);
/*        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);*/
    }


}
