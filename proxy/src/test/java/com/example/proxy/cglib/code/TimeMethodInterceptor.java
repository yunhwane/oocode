package com.example.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 실제 method proxy 사용하는 것을 권장하고 있음
     * @param obj "this", the enhanced object
     * @param method intercepted Method
     * @param args argument array; primitive types are wrapped
     * @param proxy used to invoke super (non-intercepted method); may be called
     * as many times as needed
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        log.info("time proxy 실행");
        long start = System.currentTimeMillis();
        Object result = proxy.invoke(target, args);
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("time {}ms ", resultTime);
        return result;
    }
}
