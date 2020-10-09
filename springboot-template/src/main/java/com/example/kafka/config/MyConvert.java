package com.example.kafka.config;

import com.example.kafka.model.User;
import com.example.kafka.util.AesUtil;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;

import javax.persistence.AttributeConverter;

public class MyConvert implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        String encrypt = null;
        try {
            encrypt = AesUtil.encrypt(s, "314");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return encrypt;
    }

    @Override
    public String convertToEntityAttribute(String s) {
        String decrypt = null;
        try {
            decrypt = AesUtil.decrypt(s, "314");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {

    }



}
