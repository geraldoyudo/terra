package com.isslng.terra.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Contacts")
@Data
@EqualsAndHashCode(of = "id")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ContactId")
	private String id;
	@OneToOne
	@JoinColumn(name = "BPId", referencedColumnName = "BPId")
	private BusinessPartner businessPartner;
	@Column(name = "isActive")
	private boolean active;
	@Column(name = "name")
	private String Name;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "OtherNames")
	private String otherNames;
	@Column(name = "TitleOfCourtesy")
	private String titleOfCourtesy;
	@Column(name = "ContactPhoto")
	private byte[] contactPhoto;
	@Column(name = "Salutation")
	private String salutation;
	@Column(name = "Department")
	private  String departmant;
	@Column(name = "Designation")
	private String designation;
	@Column(name = "DateofBirth")
	private String dateOfBirth;
	@Column(name = "BVN")
	private String BVN;
	@Column(name = "Religion")
	private String religion;
	@Column(name = "BirthdayGreetings")
	private String birthdayGreetings;
	@Column(name = "ChristmasGreetings")
	private String christmasGreetings;
	@Column(name = "OfficePhone1")
	private String officePhone1;
	@Column(name = "OfficePhone2")
	private String officePhone2;
	@Column(name = "OfficePhoneExt")
	private String officePhoneExt;
	@Column(name = "HousePhone")
	private String housePhone;
	@Column(name = "MobilePhone1")
	private String mobilePhone1;
	@Column(name = "MobilePhone1Status")
	private String mobilePhone1Status;
	@Column(name = "MobilePhone2")
	private String mobilePhone2;
	@Column(name = "MobilePhone2Status")
	private String mobilePhone2Status;
	@Column(name = "eMailAddress")
	private String emailAddress;
	@Column(name = "eMailAddress2")
	private String emailAddress2;
	@Column(name = "skypeAddress")
	private String skypeAddress;
	@Column(name = "LinkedInAddress")
	private String linkedInAddress;
	@Column(name = "TwitterHandle")
	private String twitterHandle;
	@Column(name = "FaceBookId")
	private String facebookId;
	@Column(name = "PreferredLanguage")
	private String preferredLanguage;
}
