package com.example.proxy.jdkdynamic;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
class ReflectionTest {

    /**
     * 호출하는 메서드만 다르고 완전히 동일한 로직이 반복됨
     * 리플렉션은 클래스나 메서드의 메타정보를 사용해서 동적으로 호출하는 메서드를 변경할 수 있다.
     */
    @Test
    void reflection0() {
        Hello target = new Hello();
        log.info("start logic");
        String result = target.callA();
        log.info("result: {}", result);

        log.info("start logic");
        result = target.callB();
        log.info("result: {}", result);
    }

    /**
     * 리플렉션을 사용해서 동적으로 메서드를 호출할 수 있다.
     * 내부 클래스의 구분을 위해 $
     * 해당 클래스의 메타 정보를 획득하여 invoke 실제 인스턴스의 메서드를 호출할 수 있음
     * 여기서 가장 중요한 건 클래스나 메서드 정보를 동적으로 변경할 수 있다는 점임
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    void reflection1() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class classHello = Class.forName("com.example.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1: {}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2: {}", result2);
    }


    /**
     * 리플렉션은 컴파일 타임에 메서드를 호출하는 것이 아니라 런타임에 메서드를 호출함
     * 리플렉션은 프레임워크 개발이나 일반적인 공통 처리가 필요할 때 부분적으로 주의해서 사용함
     */
    @Test
    void reflection2() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class classHello = Class.forName("com.example.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        dynamicCall(classHello.getMethod("callA"), target);
        dynamicCall(classHello.getMethod("callB"), target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start logic");
        Object result = method.invoke(target);
        log.info("result: {}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
