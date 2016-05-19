package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "RefAddressType")
@Data
@EqualsAndHashCode(of = "code")
public class AddressType {
	@Id
	@Column(name = "AddrTypeCode")
	private String code;
	@Column(name = "AddrTypeDescription")
	private String description;
}
