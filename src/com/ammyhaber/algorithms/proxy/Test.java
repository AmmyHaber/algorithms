package com.ammyhaber.algorithms.proxy;

public class Proxy {

    public static void main(String[] args) {
        Mapper mapper = (Mapper) java.lang.reflect.Proxy.newProxyInstance(Mapper.class.getClassLoader(), new Class[]{Mapper.class}, new ProxyHandler());
        mapper.test();
    }
}
