package com.example.kafka.demo.alibaba.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    @Test
    public void test6(){
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(1243);
    }

    @Test
    public void test11(){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
      /*  Iterator<String> iterator = list.iterator(); while (iterator.hasNext()) {
            String item = iterator.next();
            if (true) {
                iterator.remove();
            }
        }*/

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

    }



}
