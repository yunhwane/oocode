package com.example.proxy.app.v1;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV1Impl implements OrderControllerV1{

    private final OrderServiceV1 orderServiceV1;

    public OrderControllerV1Impl(OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }


    @Override
    public String request(String itemId) {
        orderServiceV1.order(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
