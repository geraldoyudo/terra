package com.isslng.terra.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.isslng.terra.storage.util.MultiTenantProperties;

@SpringBootApplication
@EnableConfigurationProperties(MultiTenantProperties.class)
public class MultiTenantTestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantTestApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MultiTenantTestApplication.class);
    }
}
