package com.example.kafka.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SfKafkaUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SfKafkaUtils.class);

    private static Producer<String, String> producer;

    private static Properties properties;

    /**
     * kafka producer 单例
     * @return
     */
    public static Producer<String, String> getProducerInstance(){
        if(producer==null){
            synchronized (SfKafkaUtils.class){
                if(producer==null){
                    Properties props = new Properties();
                    props.put("bootstrap.servers", "106.15.231.137:9092");
                    props.put("acks", "all");
                    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                    producer = new KafkaProducer<>(props);
                }
            }
        }
        return producer;
    }

    /**
     * 发送数据到kafka
     * @param topic
     * @param data
     * @return
     */
    public static boolean sendData(String topic,String data){
        try{
            Future<RecordMetadata> send = getProducerInstance().send(new ProducerRecord<>(topic, data));
            return true;
        }catch (Exception e){
            LOGGER.error("sendDataToKafka exception! topic={},data={}, exception={}",topic,data,e);
        }finally {
            closeProducer();
        }

        return false;
    }

    /**
     * 释放producer资源
     */
    public static void closeProducer(){
        try {
            if(producer!=null){
                producer.close();
                producer = null;
            }
        }catch (Exception e){
            LOGGER.error("kafkaProducer close exception. kafkaProducer={},exception={}",producer,e);
        }
    }

    /**
     * 消费数据
     * @param groupId 消费组
     * @param topics topic列表
     * @return
     */
    public static KafkaConsumer<String, String> getConsumer(String groupId, List<String> topics){
        try{
            Properties props = new Properties();
            props.setProperty("bootstrap.servers", "");
            props.setProperty("group.id", groupId);
            props.setProperty("enable.auto.commit", "true");
            props.setProperty("auto.commit.interval.ms", "1000");
            props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
            //consumer.subscribe(topics);
            return consumer;
        }catch (Exception e){
            LOGGER.error("getConsumer exception! groupId={},topics={}, exception={}",groupId,topics,e);
        }
        return null;
    }

    /**
     * 释放consumer资源
     * @param kafkaConsumer
     */
    public static void closeConsumer(KafkaConsumer kafkaConsumer){
        try{
            if(kafkaConsumer!=null){
                kafkaConsumer.close();
            }
        }catch (Exception e){
            LOGGER.error("closeConsumer exception. kafkaConsumer={}, exception={}",kafkaConsumer,e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            SfKafkaUtils.sendData("tsct-app-log","0000000"+i);
        }
    }


}
