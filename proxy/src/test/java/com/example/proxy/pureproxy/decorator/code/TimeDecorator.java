package com.example.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {

    private final Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }


    @Override
    public String operation() {
        log.info("time decorator를 호출함");
        long start = System.currentTimeMillis();

        String result = component.operation();

        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("time decorator 종료 실행시간: {}", resultTime);
        return result;
    }
}
