package com.saksham.springboot_kafka_producer_wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootKafkaProducerWikipediaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProducerWikipediaApplication.class, args);
	}

	@Autowired
	private WikimediaChangesProducer wikimediaChangesProducer;

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}
}
