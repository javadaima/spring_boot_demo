package com.example.kafka.demo.designPattern;

/**
 * 单例模式
 * 关键点：1构造私有化 2只用过静态方法获取
 */
public class Singleton {

    private static Singleton singleton;

    public static Singleton  getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    private Singleton(){

    }

}
