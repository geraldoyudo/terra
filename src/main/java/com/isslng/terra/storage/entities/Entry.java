package com.isslng.terra.storage.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(of = "entryId")
public class Entry {
	@ManyToOne
	@JoinColumns({    
	      @JoinColumn(name = "orgId", referencedColumnName = "orgId", insertable = false, updatable = false),
	      @JoinColumn(name = "serialNo",  referencedColumnName = "serialNo", insertable = false, updatable = false),
	      @JoinColumn(name = "type", referencedColumnName = "type", insertable = false, updatable = false)
	})
	private EntryHeader entryHeader;;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long entryId;
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
