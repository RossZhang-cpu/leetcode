package com.code.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Hello o = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                new MyInvocation());
        o.morning("vera");
    }
}
