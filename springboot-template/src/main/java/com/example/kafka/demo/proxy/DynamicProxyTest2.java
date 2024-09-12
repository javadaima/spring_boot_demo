package com.example.kafka.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest2 implements InvocationHandler {

    private Object target;

    public DynamicProxyTest2(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前2");
        Object object= method.invoke(target,args);
        System.out.println("调用之后2");
        return object;
    }
}
