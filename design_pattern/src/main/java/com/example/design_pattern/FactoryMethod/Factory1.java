package com.example.design_pattern.FactoryMethod;

public class Factory1 implements AbstarctFactory {
    @Override
    public AbstractProduct create() {
        System.out.println("product1");
        return new Product1();
    }
}
