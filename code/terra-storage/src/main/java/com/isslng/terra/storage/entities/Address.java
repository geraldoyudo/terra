package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Addresses")
@Data
@EqualsAndHashCode( of = "id")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressId")
	private String id;
	@Column(name = "Line_1")
	private String line1;
	@Column(name = "Line_2")
	private String line2;
	@Column(name = "Line_3")
	private String line3;
	@Column(name = "City")
	private String city;
	@Column(name = "County")
	private String county;
	@Column(name = "ZipCode")
	private String zipCode;
	@Column(name = "State")
	private String state;
	@Column(name = "CountryCode")
	private String countryCode;
	@Column(name = "AddrCheckStatus")
	private String addressCheckStatus;
	@Column(name = "AddrCheckDate")
	private String addrCheckDate;
	
}
