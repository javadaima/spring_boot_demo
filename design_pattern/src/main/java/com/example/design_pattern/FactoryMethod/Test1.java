package com.example.design_pattern.FactoryMethod;

public class Test1 {

    public static void main(String[] args) {

        Factory1 factory1 = new Factory1();
        Factory2 factory2 = new Factory2();
        AbstractProduct product1 = factory1.create();
        AbstractProduct product2 = factory2.create();
        product1.show();
        product2.show();
    }
}
