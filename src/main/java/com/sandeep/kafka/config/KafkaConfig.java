package com.sandeep.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@EnableKafka
@Configuration
public class KafkaConfig {
	public static final String group = "app3";
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		System.out.println("222 ######bean created###########################");
		Map<String , Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, group);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,  "read_committed");
		//config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,  2);
		//config.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,  600);//
		
		return new DefaultKafkaConsumerFactory<String, String>(config);
		
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		System.out.println("111 ######bean created###########################");
		ConcurrentKafkaListenerContainerFactory<String, String> factory
		= new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
		
	}
}
