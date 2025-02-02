package com.example.proxy.config.v1_proxy.interface_proxy;

import com.example.proxy.app.v1.OrderRepositoryV1;
import com.example.proxy.trace.TraceStatus;
import com.example.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    /**
     * 실제 객체 참조
     */
    private final OrderRepositoryV1 target;

    private final LogTrace logTrace;
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("orderRepositoryV1.save()");
            // target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
