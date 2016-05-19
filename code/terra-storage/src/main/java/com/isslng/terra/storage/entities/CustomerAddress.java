package com.isslng.terra.storage.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "CustomerAddress")
@Data
@EqualsAndHashCode(of = "id")
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@OneToOne
	@JoinColumn(name = "BPId", referencedColumnName = "BPId")
	private BusinessPartner businessPartner;
	@OneToOne
	@JoinColumn(name = "AddrTypeCode", referencedColumnName = "AddrTypeCode")
	private AddressType addressType;
	@Column(name = "AddrFromDate")
	private Date fromDate;
	@Column(name = "AddrThruDate")
	private Date  thruDate;
	@Column(name = "isActive")
	private boolean active;
}
