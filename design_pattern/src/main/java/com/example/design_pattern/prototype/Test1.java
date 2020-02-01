package com.example.design_pattern.prototype;

public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {

        PrototypeDemo user1 = new PrototypeDemo();
        user1.setAge(11);
        user1.setName("小明");
        user1.setSex("男");
        PrototypeDemo user2 = (PrototypeDemo)user1.clone();
        user2.setName("小华");
        System.out.println(user1.toString());
        System.out.println(user2.toString());

    }
}
