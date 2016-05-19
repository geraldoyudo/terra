package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Ledgers")
@EqualsAndHashCode(of = "code")
public class Ledger {
	@Id
	@Column(name = "LedgerCode")
	private String code;
	@Column(name = "LedgerDescription")
	private String description;
	@OneToOne
	@JoinColumn(name = "AccountType", referencedColumnName = "AcctTypeCode")
	private AccountType accountType;
}
