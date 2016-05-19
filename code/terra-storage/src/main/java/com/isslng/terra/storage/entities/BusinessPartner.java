package com.isslng.terra.storage.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "BusinessPartners")
@EqualsAndHashCode(of = "id")
public class BusinessPartner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BPId")
	private String id;
	@Column(name = "CustomerNo")
	private String customerNumber;
	@Column(name = "VendorNo")
	private String vendorNumber;
	@Column(name = "StaffNo")
	private String staffNo;
	@Column(name = "Name")
	private String name;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "OtherNames")
	private String otherNames;
	 @ManyToMany
    @JoinTable(name="BusinessPartnerRoles",
        joinColumns=
            @JoinColumn(name="BPId", referencedColumnName="BPId"),
        inverseJoinColumns=
            @JoinColumn(name="Role", referencedColumnName="Role")
        )
	private Set<Role> roles;
	
}
