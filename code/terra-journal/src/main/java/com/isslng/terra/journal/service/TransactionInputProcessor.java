package com.isslng.terra.journal.service;

import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.isslng.banking.processor.utils.EntryBuilder;

@Component
public class TransactionInputProcessor {
	@Autowired
	@Qualifier("processing")
	KieSession droolInputSession;
	
	public List<Map<String,Object>> process(EntryBuilder builder) {
		droolInputSession.insert(builder);
		droolInputSession.fireAllRules();
		return builder.build();
	}
	
}
