package com.example.proxy.app.v2;

import com.example.proxy.app.v1.OrderRepositoryV1;

public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;

    public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void order(String itemId) {
        orderRepositoryV2.save(itemId);
    }

}
