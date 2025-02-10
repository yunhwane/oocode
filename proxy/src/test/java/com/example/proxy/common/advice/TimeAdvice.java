package com.example.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


@Slf4j
public class TimeAdvice implements MethodInterceptor {
    /**
     *
     * @param invocation
     * invoacation 이 target method 를 가지고 있음
     * 프록시 생성시 target을 넘겨받음
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("time proxy 실행");
        long start = System.currentTimeMillis();
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("time {}ms ", resultTime);
        return result;
    }

}
