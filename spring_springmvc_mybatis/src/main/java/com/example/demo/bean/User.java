package com.example.demo.bean;

public class User {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "小明";
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("123");
        System.out.println(user.getName());
    }
}
