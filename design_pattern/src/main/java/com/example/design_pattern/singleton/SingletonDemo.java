package com.example.design_pattern.singleton;

public class SingletonDemo {

    private static SingletonDemo singletonDemo;

    private SingletonDemo(){

    }
    static SingletonDemo getInstance(){

        if(singletonDemo == null){
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }


}

