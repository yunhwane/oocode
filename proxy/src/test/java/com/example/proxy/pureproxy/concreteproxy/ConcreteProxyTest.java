package com.example.proxy.pureproxy.concreteproxy;

import com.example.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import com.example.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import com.example.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    /**
     * 다형성에 의해 자식 타입들도 주입이 가능함
     * 다형성은 인터페이스, 클래스 구분 없이 다형성이 적용됨
     */
    @Test
    void addTimeProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy proxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(proxy);
        concreteClient.execute();
    }
}

