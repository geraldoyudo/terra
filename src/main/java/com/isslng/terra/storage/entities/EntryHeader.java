package com.isslng.terra.storage.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @IdClass(EntryId.class)
@Data
@EqualsAndHashCode(of = {"orgId", "type", "serialNo"})
public class EntryHeader {
	@Id	private String orgId;
	@Id	private String type;
	@Id	private String serialNo;
	private String documentReference;
	private String documentType;
	private String financialYear;
	private String financialRecord;
	private String postingYear;
	private String postingRecord;
	private Date postDate;
	private Date valueDate;
	private String postedBy;
	private String postedFromIP;
	private String reviewedBy;
	private String reviewedFromIP;
	private String approvedBy;
	private String approvedFromIP;
	private String remarks;
	@Column(unique = true)
	private String entityHeaderId;
	private Long entityCount;
	private BigDecimal proofTotal;
	@OneToMany(mappedBy = "entryHeader", cascade = CascadeType.PERSIST)
	private Set<Entry> entries = new HashSet<Entry>();
}