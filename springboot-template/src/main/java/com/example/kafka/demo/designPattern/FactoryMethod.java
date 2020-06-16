package com.example.kafka.demo.designPattern;

/**
 * 工厂方法：创建与使用相分离
 */
public class FactoryMethod {
    public interface AbstractFactory{
        AbstractProduct createProduct();
    }
    public interface AbstractProduct{
        void show();
    }
    public static class Product1 implements AbstractProduct{

        @Override
        public void show() {
            System.out.println("这是Product1");
        }
    }
    public static class Product2 implements AbstractProduct{

        @Override
        public void show() {
            System.out.println("这是Product2");
        }
    }

    public static class Factory1 implements AbstractFactory{
        @Override
        public AbstractProduct createProduct() {
            return new Product1();
        }
    }

    public static class Factory2 implements AbstractFactory{
        @Override
        public AbstractProduct createProduct() {
            return new Product2();
        }
    }

    public static void main(String[] args) {
        AbstractFactory factory1 = new Factory1();
        AbstractFactory factory2 = new Factory2();
        AbstractProduct product1 = factory1.createProduct();
        AbstractProduct product2 = factory2.createProduct();
        product1.show();
        product2.show();
    }

}
