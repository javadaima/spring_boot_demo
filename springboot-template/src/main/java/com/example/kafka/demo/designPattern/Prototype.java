package com.example.kafka.demo.designPattern;

/**
 * 原型模式：
 * 主要通过clone方法复制对象
 */
public class Prototype implements Cloneable{

    private Prototype prototype;


    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        Prototype clone1 = prototype.clone();
        System.out.println(1243);
    }
}
