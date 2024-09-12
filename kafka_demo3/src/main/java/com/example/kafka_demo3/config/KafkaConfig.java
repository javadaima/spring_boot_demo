package com.example.kafka_demo3.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author: kl @kailing.pub
 * @date: 2019/5/31
 */
@Configuration
public class KafkaConfig {

	/*@Bean
	public KafkaAdmin admin(KafkaProperties properties){
		KafkaAdmin admin = new KafkaAdmin(properties.buildAdminProperties());
		admin.setFatalIfBrokerNotAvailable(true);
		return admin;
	}
	@Bean
	public NewTopic topic2() {
		return new NewTopic("test1", 1, (short) 1);
	}*/
}
