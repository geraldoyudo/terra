package com.isslng.terra.journal.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.isslng.banking.processor.entities.TransactionInput;
import com.isslng.banking.processor.exception.TransactionValidatorException;

@Component
public class TransactionInputValidator {
	@Autowired
	@Qualifier("validation")
	KieSession droolInputSession;
	
	public void evaluate(TransactionInput ti) {
		System.out.println(droolInputSession);
		droolInputSession.insert(ti);
		droolInputSession.fireAllRules();
		if(ti.meta("invalid")!= null && (boolean)ti.meta("invalid") == true){
			throw new TransactionValidatorException((String)ti.meta("invalidMessage"));
		}
		
	}
}
