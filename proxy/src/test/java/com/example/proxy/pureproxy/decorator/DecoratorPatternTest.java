package com.example.proxy.pureproxy.decorator;

import com.example.proxy.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

class DecoratorPatternTest {

    @Test
    void testNoDecoratorPattern() {
        Component component = new RealComponent();
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(component);

        decoratorPatternClient.operation();
     }

     @Test
    void testDecoratorPattern1() {
        Component realComponent = new RealComponent();
        Component messageDecoratorProxy = new MessageDecorator(realComponent);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecoratorProxy);

        decoratorPatternClient.operation();
     }

     @Test
    void testDecoratorPattern2() {
        Component realComponent = new RealComponent();
        Component messageDecoratorProxy = new MessageDecorator(realComponent);
        Component timeDecoratorProxy = new TimeDecorator(messageDecoratorProxy);

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecoratorProxy);
        decoratorPatternClient.operation();
     }

}
