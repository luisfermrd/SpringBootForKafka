package com.kafka.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBootForProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
            kafkaTemplate.send("kafka-Topic", "Prueba final Kafka");
        };
	}

}

