package com.isslng.terra.storage.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isslng.terra.storage.entities.Account;

@Component
public class Populator {
	@Autowired
	AccountRepository accountRepository;
	
	
	@PostConstruct
	public void initRepo(){
		if(accountRepository.findAll().isEmpty()){
			Account account = new Account();
			account.setAccountId("PTCSH/00/00/00");
			account.setAccountNo("PTCSH/00/00/00");
			account.setAlternateAccount("PTCSH/00/00/00");
		}
		
	}
}
