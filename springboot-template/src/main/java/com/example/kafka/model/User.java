package com.example.kafka.model;


import javax.persistence.*;

@Entity
@Table(name="sys_user")
public class User {

    @Id   // 表明id
    @GeneratedValue   //  自动生成
    private Long id ;
    @Column(name="NAME")
    private String name ;
    @Column(name="PHONE_NUMBER")
    private String phoneNumber ;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="AGE")
    private Integer age;
    @Column(name="SEX")
    private String sex;

    @Override
    public int hashCode() {
        return id.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User student = (User) obj;
            return this.id == student.id;
        }
        else {
            return false;
        }
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
