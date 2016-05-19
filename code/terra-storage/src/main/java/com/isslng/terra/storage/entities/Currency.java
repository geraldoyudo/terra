package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Currencys")
@EqualsAndHashCode(of = "id")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CcyId")
	private String id;
	@Column(name = "CcyCode")
	private String code;
	@Column(name = "CcyName")
	private String name;
	@Column(name = "CcySymbol")
	private String symbol;
	@Column(name = "ISOCode")
	private String isoCode;
	@Column(name = "isBaseCCY")
	private boolean baseCCY;
	@Column(name = "isActive")
	private boolean active;
}
