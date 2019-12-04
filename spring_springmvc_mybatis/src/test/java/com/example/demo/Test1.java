package com.example.demo;

import org.junit.Test;

public class Test1 {

    @Test
    public void test1(){

        test2();
        System.out.println(1243);
    }

    public void test2(){
        System.out.println(124);
        System.out.println(1/0);
    }
}
