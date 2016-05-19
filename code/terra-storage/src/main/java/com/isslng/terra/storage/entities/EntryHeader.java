package com.isslng.terra.storage.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity (name = "EntryHeader") @IdClass(EntryId.class)
@Data
@EqualsAndHashCode(of = {"orgId", "entryType", "serialNo"})
public class EntryHeader {
	@Id	
	@Column(name = "OrgId")
	private String orgId;
	@Id	
	@Column(name = "EntryType")
	private String entryType;
	@Id	
	@Column(name = "SerialNo")
	private String serialNo;
	@Column(name = "EntryHeaderId")
	private String entryHeaderId;
	@Column(name = "DocumentReference")
	private String documentReference;
	@Column(name = "DocumentType")
	private String documentType;
	@Column(name = "FinancialYear")
	private String financialYear;
	@Column(name = "FinancialRecord")
	private String financialRecord;
	@Column(name = "PostingYear")
	private String postingYear;
	@Column(name = "PostingRecord")
	private String postingRecord;
	@Column(name = "PostDate")
	private Date postDate;
	@Column(name = "ValueDate")
	private Date valueDate;
	@Column(name = "PostedBy")
	private String postedBy;
	@Column(name = "PostedFromIP")
	private String postedFromIP;
	@Column(name = "ReviewedBy")
	private String reviewedBy;
	@Column(name = "ReviewedFromIP")
	private String reviewedFromIP;
	@Column(name = "ApprovedBy")
	private String approvedBy;
	@Column(name = "ApprovedFromIP")
	private String approvedFromIP;
	@Column(name = "Remarks")
	private String remarks;
	@Column(name = "EntryCount")
	private Long entryCount;
	@Column(name = "ProofTotal")
	private BigDecimal proofTotal;
	@OneToMany(mappedBy = "entryHeader", cascade = CascadeType.PERSIST)
	private Set<Entry> entries = new HashSet<Entry>();
}
