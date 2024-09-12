package com.example.design_pattern.FactoryMethod;

public class Factory2 implements AbstarctFactory {
    @Override
    public AbstractProduct create() {
        System.out.println("product2");
        return new Product2();
    }

}
