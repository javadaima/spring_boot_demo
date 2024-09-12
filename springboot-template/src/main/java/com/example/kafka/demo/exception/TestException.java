package com.example.kafka.demo.exception;

import org.junit.jupiter.api.Test;

public class TestException {

    @Test
    public void test1(){
        try{
            test2();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void test2(){
        test3();
    }
    private void test3(){
        throw new RuntimeException();
    }

}
