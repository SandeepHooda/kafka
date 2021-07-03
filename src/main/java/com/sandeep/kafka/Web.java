package com.sandeep.kafka;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Web {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	@GetMapping("/kafka")
	public String publish() {
	
		
		kafkaTemplate.send("first_topic", ""+System.currentTimeMillis());
		return "done";
	}

}
