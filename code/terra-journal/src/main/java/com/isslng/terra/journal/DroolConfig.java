package com.isslng.terra.journal;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isslng.terra.journal.service.DroolsImporter;

	

@Configuration
public class DroolConfig {
	@Autowired
	DroolsImporter droolsImporter;
	@Bean
	KieServices kieServices(){
		return KieServices.Factory.get();
	}
	@Bean
	KieContainer kieContainer(KieServices kieServices){
		return kieServices.getKieClasspathContainer();
	}
	
	@Bean
	@Qualifier("validation")
	KieSession validityEvaluatpr(KieContainer kieContainer){
		return kieContainer.newKieSession("validation-rules");
	}
	
	@Bean
	@Qualifier("processing")
	KieSession processingEvaluator(KieContainer kieContainer){
		return kieContainer.newKieSession("processing-rules");
	}
}
