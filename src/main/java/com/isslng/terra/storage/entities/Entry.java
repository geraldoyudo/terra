package com.isslng.terra.storage.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Entry {
	@ManyToOne
	@JoinColumns({    
	      @JoinColumn(name = "orgId"),
	      @JoinColumn(name = "type"),
	      @JoinColumn(name = "serialNo")
	})
	private EntryHeader entryHeader;;
	@Id
	private String entryId;
	private String accountNo;
	private String narrative;
	private String currency;
	private boolean ccyDebit;
	private boolean ccyCredit;
	private BigDecimal ccyAmount;
	private float rate;
	private boolean debit;
	private boolean credit;
	private BigDecimal amount;
	private String transactionAnalysisCode;
}
