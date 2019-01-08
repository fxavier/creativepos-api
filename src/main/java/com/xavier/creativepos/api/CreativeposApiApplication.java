package com.xavier.creativepos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.xavier.creativepos.api.config.property.CreativeposProperty;

@SpringBootApplication
@EnableConfigurationProperties(CreativeposProperty.class)
public class CreativeposApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreativeposApiApplication.class, args);
	}
}
