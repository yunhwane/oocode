package com.example.proxy.pureproxy.decorator.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {

    @Override
    public String operation() {
        log.info("실제 객체의 operation() 메서드 호출");
        return "data";
    }

}
