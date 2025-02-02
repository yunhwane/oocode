package com.example.proxy;

import com.example.proxy.code.ProxyPatternClient;
import com.example.proxy.code.RealSubject;
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


}
