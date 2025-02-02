package com.example.proxy.pureproxy.proxy.code;


import lombok.extern.slf4j.Slf4j;


/**
 * 캐시 프록시
 * - 실제 객체의 결과를 캐시하여 중복 호출을 방지
 * - 캐시가 없을 경우에만 실제 객체를 호출
 * 프록시 객체는 실제 객체와 같은 인터페이스를 구현해야 한다.
 * 프록시 객체는 실제 객체를 참조하고 있어야 한다.
 */
@Slf4j
public class CacheProxy implements Subject{

    private final Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("캐시 프록시를 호출함");

        if(cacheValue == null) {
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}
