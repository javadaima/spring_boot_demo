package com.example.kafka.demo.designPattern;

/**
 * 代理模式：有点类似于装饰模式，代理类需要伪装成目标类，起到鱼目混珠色效果
 */
public class Proxy {

    public interface Person{
        void say();
    }

    public static class Person1 implements Person{
        @Override
        public void say() {
            System.out.println("这是Person1");
        }
    }

    public static class Proxy1 implements Person{

        private Person person;

        public Proxy1(Person person) {
            this.person = person;
        }
        @Override
        public void say() {
            System.out.println("执行前");
            person.say();
            System.out.println("执行后");
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person1();
        Person proxy1 = new Proxy1(person1);
        proxy1.say();
    }

}
