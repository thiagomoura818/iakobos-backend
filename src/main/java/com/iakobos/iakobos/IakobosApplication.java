package com.iakobos.iakobos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class IakobosApplication {

	public static void main(String[] args) {
		SpringApplication.run(IakobosApplication.class, args);
	}

}
