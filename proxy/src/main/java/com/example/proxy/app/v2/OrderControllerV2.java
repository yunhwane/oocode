package com.example.proxy.app.v2;

import org.springframework.web.bind.annotation.*;


@RequestMapping
@RestController
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;

    public OrderControllerV2(OrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    @GetMapping("/v2/request")
    public String request(@RequestParam(name = "itemId") String itemId) {
        orderServiceV2.order(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }


}
