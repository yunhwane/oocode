package com.example.proxy.config.v2_dynamicproxy.handler;

import com.example.proxy.trace.TraceStatus;
import com.example.proxy.trace.logtrace.LogTrace;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceFilterHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;
    private final String[] petterns;

    public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] petterns) {
        this.target = target;
        this.logTrace = logTrace;
        this.petterns = petterns;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        // method
        String methodName = method.getName();
        if(!PatternMatchUtils.simpleMatch(petterns, methodName)){
            return method.invoke(target, args);
        }

        TraceStatus status = null;

        try {
            String messege = method.getDeclaringClass().getSimpleName()+"."+method.getName()+"()";
            status = logTrace.begin(messege);

            // 로직 호출
            Object result = method.invoke(target, args);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
