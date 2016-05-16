package com.isslng.terra.storage.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "accountNo")
public class Account {
	@Id
	private String accountNo;
	private String accountId;
	private String alternateAccount;
	
}
