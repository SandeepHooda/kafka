package com.sandeep.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandeep.kafka.config.KafkaConfig;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);

		Properties config = new Properties();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfig.group);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,  "read_committed");
		
		
	/*	KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);
	     consumer.subscribe(Arrays.asList("first_topic"));
	     
	     while (true) {
	    	 long delay = 10000L;
	    	 System.out.println(" poll ");//This log statement will print every "delay" miliseconds. but if there is messages then returns immediately
	         ConsumerRecords<String, String> records = consumer.poll(delay);
	         for (ConsumerRecord<String, String> record : records) {
	            System.out.println(record);
	            Long start = Long.parseLong(record.value());
	    		
	    		System.out.println(" consumed message delay "+(System.currentTimeMillis() - start));
	         }
	        
	     }*/
		System.out.println(" main ends");
	}

}
