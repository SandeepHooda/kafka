package com.sandeep.kafka.srv;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sandeep.kafka.config.KafkaConfig;



//@Service

public class Listner2 {
	
	public Listner2() {
		System.out.println(" listner created 2");
	}

	//@KafkaListener(topics = "first_topic", groupId = KafkaConfig.group )
	public void consume(String message) {
		Long start = Long.parseLong(message);
		
		System.out.println(" consumed message delay "+(System.currentTimeMillis() - start));
	}
	
	
}
