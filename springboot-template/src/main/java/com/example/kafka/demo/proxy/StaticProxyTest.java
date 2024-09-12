package com.example.kafka.demo.proxy;

public class StaticProxyTest implements Person{
    private Person person;

    public StaticProxyTest(Person person) {
        this.person = person;
    }

    @Override
    public String say() {
        System.out.println("之前");
        person.say();
        System.out.println("之后");
        return "ccc";
    }

    public static void main(String[] args) {
        Person1 person1 = new Person1();
        StaticProxyTest staticProxyTest = new StaticProxyTest(person1);
        staticProxyTest.say();
    }
}
