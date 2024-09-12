package com.example.kafka.demo.proxy;

public class Person1 implements Person,Man{


    @Override
    public String say() {
        System.out.println("这是person1");
        return "这是Person1返回值";
    }

    @Override
    public void run() {
        System.out.println("这是person1.run");
    }
}
