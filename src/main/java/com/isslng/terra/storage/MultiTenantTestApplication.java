package com.isslng.terra.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.isslng.terra.storage.util.MultiTenantProperties;

@SpringBootApplication
@EnableConfigurationProperties(MultiTenantProperties.class)
public class MultiTenantTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantTestApplication.class, args);
	}
}
