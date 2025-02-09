package com.example.proxy.jdkdynamic;


import com.example.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;


/**
 * JDK Dynamic Proxy
 * 적용 대상 만큼 프록시 객체를 생성하지 않고 부가 기능 로직을 한번만 개발해서 공통으로 적용할 수 있다.
 * 즉, 각각 필요한 InvocationHandler를 구현해서 사용하면 됨
 * 부가 기능 로직도 하나의 클래스를 모아서 SRP 원칙을 지킬수 있게 되었음
 */

@Slf4j
class JdkDynamicProxyTest {

    @Test
    void jdkDynamicProxy() {
        Ainterface ainterface = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(ainterface);

        Ainterface proxy = (Ainterface) Proxy.newProxyInstance(Ainterface.class.getClassLoader(), new Class[]{Ainterface.class}, handler);
        proxy.call();
        log.info("targetClass: {}", ainterface.getClass());
        log.info("proxyClass: {}", proxy.getClass());

    }

    @Test
    void jdkDynamicProxyB() {
        Binterface binterface = new Bimpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(binterface);

        Binterface proxy = (Binterface) Proxy.newProxyInstance(Binterface.class.getClassLoader(), new Class[]{Binterface.class}, handler);
        proxy.call();
        log.info("targetClass: {}", binterface.getClass());
        log.info("proxyClass: {}", proxy.getClass());
    }
}
