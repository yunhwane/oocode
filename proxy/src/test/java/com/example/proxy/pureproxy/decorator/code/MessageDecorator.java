package com.example.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private final Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("메시지 데코레이터를 호출함");
        String result = component.operation();
        String decoResult = "*****" +result + "*****";
        log.info("적용전 = {}, 적용후 = {}", result, decoResult);
        return decoResult;
    }
}
