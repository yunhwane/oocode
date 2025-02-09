package com.example.proxy.cglib;


import com.example.proxy.cglib.code.TimeMethodInterceptor;
import com.example.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib proxy test
 * 클래스 기반 프록시는 상속을 통해 구현한다.
 * 클래스에 final 키워드가 붙으면 상속이 불가능하기 때문에 cglib proxy를 사용할 수 없다.
 * 메서드에 final 키워드가 붙으면 메서드를 오버라이딩 할 수 없기 때문에 cglib proxy를 사용할 수 없다.
 *
 */
@Slf4j
class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("target class : {}", target.getClass());
        log.info("proxy class : {}", proxy.getClass());

        proxy.call();
    }
}
