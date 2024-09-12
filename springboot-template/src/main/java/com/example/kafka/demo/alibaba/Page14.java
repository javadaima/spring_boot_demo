package com.example.kafka.demo.alibaba;

import com.example.kafka.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Page14 {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(1L);
        HashSet<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        System.out.println(1243);

        HashSet<Long> longs = new HashSet<>();
        longs.add(7111L);
        longs.add(7111L);
        System.out.println(124);

        HashSet<Integer> integers = new HashSet<>();
        Integer a = 7111;
        integers.add(a);
        Integer b = new Integer(7111);
        integers.add(b);
        System.out.println(b.hashCode());
        System.out.println(124);
    }


    @Test
    public void test1(){
        String str = "test1";
        System.out.println(1234);
        List<String> strings = new ArrayList<>();
        List<String> strings1 = strings.subList(0, 1);
    }
}


