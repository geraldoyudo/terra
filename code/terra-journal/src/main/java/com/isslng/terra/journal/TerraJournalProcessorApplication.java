package com.isslng.terra.journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class TerraJournalProcessorApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TerraJournalProcessorApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TerraJournalProcessorApplication.class);
    }

}
