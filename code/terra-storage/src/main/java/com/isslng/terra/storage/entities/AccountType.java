package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "AccountTypes")
@EqualsAndHashCode(of = "code")
public class AccountType {
	@Id
	@Column(name = "AcctTypeCode")
	private String code;
	@Column(name = "AcctType")
	private char type;
}
