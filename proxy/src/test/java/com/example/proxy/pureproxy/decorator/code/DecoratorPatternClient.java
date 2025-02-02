package com.example.proxy.pureproxy.decorator.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternClient {

    private Component component;

    public DecoratorPatternClient(Component component) {
        this.component = component;
    }

    public void operation() {
        String result = component.operation();
        log.info("결과: {}", result);
    }
}
