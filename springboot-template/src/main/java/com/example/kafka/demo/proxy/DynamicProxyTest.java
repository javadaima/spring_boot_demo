package com.example.kafka.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest implements InvocationHandler {

    private Object target;

    public DynamicProxyTest(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        Object object= method.invoke(target,args);
        System.out.println("调用之后");
        return object;
    }
    public static void main(String [] args){
        Person person1=new Person1();
        InvocationHandler handler=new DynamicProxyTest(person1) ;
        InvocationHandler handler2=new DynamicProxyTest2(person1) ;
        //生成代理对象实例 括号的第一个参数是类加载器 第二个参数表示把生成的动态代理对象下挂在哪些接口下，第三个是定义方法逻辑的代理类 invoke 方法就是代理逻辑方法现实方法 感兴趣的同学可以研究下源码
        Person  person11= (Person)  Proxy.newProxyInstance(person1.getClass().getClassLoader(),person1.getClass().getInterfaces(),handler);
        Person  person12= (Person)  Proxy.newProxyInstance(person1.getClass().getClassLoader(),person1.getClass().getInterfaces(),handler2);
        person11.say();
        person12.say();

        Man  man11= (Man)  Proxy.newProxyInstance(person1.getClass().getClassLoader(),person1.getClass().getInterfaces(),handler);
        man11.run();
    }
}
