package com.naturecode.kafka_spring.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private KafkaProducer producer;

	@Override
	public void run(String... strings) throws Exception {
		for (int i=0; i<150; i++){
			producer.send(Integer.toString(i), "Hello my son!");
		}
	}
}
