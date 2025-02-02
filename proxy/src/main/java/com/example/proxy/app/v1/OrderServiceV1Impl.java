package com.example.proxy.app.v1;


import org.springframework.stereotype.Service;


public class OrderServiceV1Impl implements OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;

    public OrderServiceV1Impl(OrderRepositoryV1 orderRepositoryV1) {
        this.orderRepositoryV1 = orderRepositoryV1;
    }

    @Override
    public void order(String itemId) {
        orderRepositoryV1.save(itemId);
    }
}
