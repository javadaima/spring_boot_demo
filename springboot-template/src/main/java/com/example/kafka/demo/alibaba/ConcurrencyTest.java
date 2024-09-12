package com.example.kafka.demo.alibaba;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrencyTest {

    @Test
    public void test5(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String format1 = format.format(new Date());

    }

}
