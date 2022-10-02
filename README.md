# SpringBootMicroservices

http://localhost:9191/order/bookOrder

{
    "order": {
        "id": 33,
        "name": "iphone",
        "qty": 4,
        "price": 3444
    },
    "payment": {}
}

http://localhost:9393/payment/doPayment

{
"paymentStatus":"success"

}

http://localhost:8765/PAYMENT-SERVICE/payment/doPayment

{
"paymentStatus":"success"

}


http://localhost:8765/ORDER-SERVICE/order/bookOrder
{
    "order": {
        "id": 30,
        "name": "mobile",
        "qty": 4,
        "price": 3444
    },
    "payment": {}
}


http://localhost:8765/ORDER-SERVICE/order/bookOrder
