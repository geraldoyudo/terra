package com.isslng.terra.storage.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity(name = "Entries")
@Data
@EqualsAndHashCode(of = "id")
public class Entry {
	@ManyToOne
	@JoinColumns({    
	      @JoinColumn(name = "OrgId", referencedColumnName = "OrgId", insertable = false, updatable = false),
	      @JoinColumn(name = "SerialNo",  referencedColumnName = "SerialNo", insertable = false, updatable = false),
	      @JoinColumn(name = "EntryType", referencedColumnName = "EntryType", insertable = false, updatable = false)
	})
	private EntryHeader entryHeader;;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "AccountNo")
	private String accountNo;
	@Column(name = "Narrative")
	private String narrative;
	@Column(name = "Currency")
	private String currency;
	@Column(name = "CcyDebit")
	private BigDecimal ccyDebit;
	@Column(name = "CcyCredit")
	private BigDecimal ccyCredit;
	@Column(name = "CcyAmount")
	private BigDecimal ccyAmount;
	@Column(name = "rate")
	private float rate;
	@Column(name = "Debit")
	private BigDecimal debit;
	@Column(name = "Credit")
	private BigDecimal credit;
	@Column(name = "Amount")
	private BigDecimal amount;
	@Column(name = "TransactionAnalysisCode")
	private String transactionAnalysisCode;
}
