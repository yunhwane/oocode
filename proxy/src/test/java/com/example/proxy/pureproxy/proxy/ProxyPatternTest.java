package com.example.proxy.pureproxy.proxy;

import com.example.proxy.pureproxy.proxy.code.CacheProxy;
import com.example.proxy.pureproxy.proxy.code.ProxyPatternClient;
import com.example.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

class ProxyPatternTest {


    /**
     * 3초 시간이 걸림
     */
    @Test
    void noProxyPattern() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);

        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }

    /**
     * 최초 1초 시간이 걸림
     * 2회부터는 캐시된 데이터를 사용하여 0초 시간이 걸림
     * 실제 클라이언트 입장에서 봤을 때 프록시 객체인지 실제 객체인지 모르게 구현
     */
    @Test
    void proxyPattern() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);

        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }
}
