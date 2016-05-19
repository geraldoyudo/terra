package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Accounts")
@Data
@EqualsAndHashCode(of = "accountNo")
public class Account {
	@Id
	@Column(name = "AccountNo")
	private String accountNo;
	@Column(name = "OrgId")
	private String orgId;
	@OneToOne
	@JoinColumn(name = "LedgerCode", referencedColumnName = "LedgerCode")
	private Ledger ledger;
	@ManyToOne
	@JoinColumn(name= "CcyCode", referencedColumnName = "CcyCode")
	private Currency currency;
	@OneToOne
	@JoinColumn(name= "BPId", referencedColumnName = "BPId")
	private BusinessPartner businessPartner;
	@Column(name = "Name")
	private String name;
	@Column(name = "Description")
	private String description;
	@Column(name = "isActive")
	private boolean active;
	@Column(name = "isSummary")
	private boolean summary;
	@Column(name = "AccountSign")
	private char sign;

	
}
