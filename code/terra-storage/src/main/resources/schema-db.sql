CREATE TABLE AccountTypes(
	AcctTypeCode char(1) NOT NULL,
	AcctType varchar(50) NULL,
    PRIMARY KEY ( AcctTypeCode ASC)
);

CREATE TABLE Ledgers(
	LedgerCode varchar(10) NOT NULL,
	LedgerDescription varchar(50) NULL,
	AccountType char(1) NULL,
    PRIMARY KEY ( LedgerCode ASC ),
	KEY FK_Ledgers_AccountTypes (AccountType),
	CONSTRAINT FK_Ledgers_AccountTypes FOREIGN KEY(AccountType) REFERENCES AccountTypes (AcctTypeCode)	
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE Currencys(
	CcyId bigint(20) NOT NULL auto_increment,
	CcyCode varchar(10) NULL,
	CcyName varchar(10) NULL,
	CcySymbol varchar(10) NULL,
	ISOCode varchar(10) NULL,
	isBaseCCY bit NULL,
	isActive bit NULL,
	PRIMARY KEY ( CcyId ASC ),
	UNIQUE KEY unique_CcyCode (CcyCode)
);


CREATE TABLE BusinessPartners(
	BPId bigint(20) NOT NULL auto_increment,
	CustomerNo varchar(10) NULL, /*issue - why have three numbers when you can have one and a type*/
	VendorNo varchar(10) NULL,
	StaffNo varchar(10) NULL,
	Name varchar(50) NULL,
	FirstName varchar(50) NULL,
	OtherNames varchar(50) NULL,
	PRIMARY KEY ( BPId ASC )
);


CREATE TABLE Accounts(
	OrgId varchar(20) NULL,
	LedgerCode varchar(10) NULL,
	CcyCode varchar(10) NULL,
	AccountNo varchar(50) NOT NULL,
	BPId bigint(20) NULL,
	Name varchar(50) NULL,
	Description varchar(255) NULL,
	isActive bit NULL,
	isSummary bit NULL,
	AccountSign char(1) NULL,
    PRIMARY KEY (AccountNo ASC ),
	KEY FK_Accounts_Ledgers(LedgerCode),
    CONSTRAINT FK_Accounts_Ledgers FOREIGN KEY(LedgerCode) REFERENCES Ledgers (LedgerCode)
	ON UPDATE CASCADE
	ON DELETE CASCADE,	
	KEY FK_Accounts_Currencys(CcyCode),
    CONSTRAINT FK_Accounts_Currencys FOREIGN KEY(CcyCode) REFERENCES Currencys (CcyCode)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
    KEY FK_Accounts_BusinessPartners(BPId),
	CONSTRAINT FK_Accounts_BusinessPartners FOREIGN KEY(BPId) REFERENCES BusinessPartners (BPId)
	ON UPDATE CASCADE
	ON DELETE CASCADE

);

CREATE TABLE Roles(
	Role varchar(20) NOT NULL,
	PRIMARY KEY ( Role ASC )
);

CREATE TABLE BusinessPartnerRoles(
	BPId bigint(20) NOT NULL,
	Role varchar(20) NOT NULL,
	BPIDRoleID varchar(50) NULL, 
	PRIMARY KEY ( BPId ASC, Role ASC),
	KEY FK_BusinessPartnerRoles_BusinessPartners (BPId),
	CONSTRAINT FK_BusinessPartnerRoles_BusinessPartners FOREIGN KEY (BPId) REFERENCES  BusinessPartners (BPId)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	KEY FK_BusinessPartnerRoles_Roles (Role),
	CONSTRAINT FK_BusinessPartnerRoles_Roles FOREIGN KEY (Role) REFERENCES  Roles (Role)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE AccountMap(
	OrgId varchar(20) NULL,
	LedgerCode varchar(10) NULL,
	CcyCode varchar(10) NULL,
	NaturalAccount varchar(50) NULL,
	ProductCode varchar(10) NULL,
	ProjectCode varchar(10) NULL,
	LocationCode varchar(10) NULL,
	CampaignCode varchar(10) NULL,
	ActivityCode varchar(10) NULL,
	AnalysisAccountNo varchar(255) NULL,
	AccountAlias varchar(50) NULL,
	AltAccountNo varchar(50) NULL
);

CREATE TABLE Contacts(
	ContactId bigint NOT NULL auto_increment,
	BPId bigint(20) NOT NULL,  
	isActive bit NULL,
	Name varchar(50) NULL,
	FirstName varchar(50) NULL,
	OtherNames varchar(50) NULL,
	TitleofCourtesy varchar(50) NULL,
	ContactPhoto longblob NULL,
	Salutation varchar(50) NULL,
	Department varchar(50) NULL,
	Designation varchar(50) NULL,
	DateofBirth date NULL,
	BVN varchar(50) NULL,
	Religion varchar(50) NOT NULL,
	BirthdayGreetings bit NULL,
	ChristmasGreetings bit NULL,
	OfficePhone1 varchar(20) NULL,
	OfficePhone2 varchar(20) NULL,
	OfficePhoneExt varchar(10) NULL,
	HousePhone varchar(20) NULL,
	MobilePhone1 varchar(20) NULL,
	MobilePhone1Status varchar(20) NULL,
	MobilePhone2 varchar(20) NULL,
	MobilePhone2Status varchar(20) NULL,
	eMailAddress varchar(50) NULL,
	eMailAddress2 varchar(50) NOT NULL,
	skypeAddress varchar(50) NULL,
	LinkedInAddress varchar(50) NULL,
	TwitterHandle varchar(50) NULL,
	FaceBookId varchar(50) NULL,
	PreferredLanguage varchar(20) NULL,
	PRIMARY KEY (	ContactId ASC ),
	KEY FK_Contacts_BusinessPartners (BPId),
	CONSTRAINT FK_Contacts_BusinessPartners FOREIGN KEY (BPId) REFERENCES  BusinessPartners (BPId)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE Addresses(
	AddressId bigint(20) NOT NULL auto_increment,
	Line_1 varchar(50) NULL,
	Line_2 varchar(50) NULL,
	Line_3 varchar(50) NULL,
	City varchar(50) NULL,
	County varchar(50) NULL,
	ZipCode varchar(10) NULL,
	State varchar(50) NULL,
	CountryCode varchar(10) NULL,
	AddrCheckStatus varchar(10) NULL,
	AddrCheckDate date NULL,
	PRIMARY KEY (AddressId asc)
);

CREATE TABLE RefAddressTypes(
	AddrTypeCode varchar(10) NOT NULL,
	AddrTypeDescription varchar(50) NULL,
    PRIMARY KEY ( AddrTypeCode ASC)
);


CREATE TABLE CustomerAddresses(
	CustomerAddressId bigint(20) NOT NULL auto_increment,
	BPId bigint(20) NULL,
	AddressId bigint NULL,
	AddrTypeCode nchar(10) NULL,
	AddrFromDate date NULL,
	AddrThruDate date NULL,
	isActive bit NULL,
    PRIMARY KEY ( CustomerAddressId ASC ),
	KEY FK_CustomerAddresses_Addresses (AddressId),
	CONSTRAINT FK_CustomerAddresses_Addresses FOREIGN KEY (AddressId) REFERENCES Addresses (AddressId)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	KEY FK_CustomerAddresses_BusinessPartners (BPId),
	CONSTRAINT FK_CustomerAddresses_BusinessPartners FOREIGN KEY (BPId) REFERENCES BusinessPartners (BPId)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	KEY FK_CustomerAddresses_RefAddressTypes (AddrTypeCode),
	CONSTRAINT FK_CustomerAddresses_RefAddressTypes FOREIGN KEY (AddrTypeCode) REFERENCES RefAddressTypes (AddrTypeCode)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE EntryHeader (
   OrgId varchar(255) NOT NULL,
   SerialNo varchar(255) NOT NULL,
   EntryType varchar(255) NOT NULL,
   ApprovedBy varchar(255) DEFAULT NULL,
   ApprovedFromIP varchar(255) DEFAULT NULL,
   DocumentReference varchar(255) DEFAULT NULL,
   DocumentType varchar(255) DEFAULT NULL,
   EntryCount bigint(20) NOT NULL,
   EntryHeaderId bigint(20) NOT NULL auto_increment,
   FinancialRecord varchar(255) DEFAULT NULL,
   FinancialYear varchar(255) DEFAULT NULL,
   PostDate datetime DEFAULT CURRENT_TIMESTAMP,
   PostedBy varchar(255) DEFAULT NULL,
   PostedFromIP varchar(255) DEFAULT NULL,
   PostingRecord varchar(255) DEFAULT NULL,
   PostingYear varchar(255) DEFAULT NULL,
   ProofTotal decimal(19,2) DEFAULT 0,
   Remarks varchar(255) DEFAULT NULL,
   ReviewedBy varchar(255) DEFAULT NULL,
   ReviewedFromIP varchar(255) DEFAULT NULL,
   ValueDate datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (OrgId,SerialNo,EntryType),
  UNIQUE KEY unique_entryHeaderId (EntryHeaderId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Entries (
   EntryId bigint(20) NOT NULL AUTO_INCREMENT,
   AccountNo varchar(255) NOT NULL,
   Amount decimal(19,2) DEFAULT 0,
   CcyAmount decimal(19,2) DEFAULT 0,
   CcyCredit  decimal(19,2) DEFAULT 0,
   CcyDebit decimal(19,2) DEFAULT 0,
   Credit  decimal(19,2) DEFAULT 0,
   Currency varchar(255) DEFAULT NULL,
   Debit  decimal(19,2) DEFAULT 0,
   Narrative varchar(255) DEFAULT NULL,
   Rate float DEFAULT 1,
   TransactionAnalysisCode varchar(255) DEFAULT NULL,
   OrgId varchar(255) DEFAULT NULL,
   SerialNo varchar(255) DEFAULT NULL,
   EntryType varchar(255) DEFAULT NULL,
   PRIMARY KEY ( EntryId),
   KEY FK_OrgId_SerialNo_entryType ( OrgId,SerialNo,EntryType),
   CONSTRAINT FK_OrgId_SerialNo_entryType FOREIGN KEY (OrgId, SerialNo, EntryType) REFERENCES EntryHeader ( OrgId, SerialNo, EntryType),
   /*
   KEY FK_Entries_AccountNo (AccountNo),
   CONSTRAINT FK_Entries_AccountNo FOREIGN KEY (AccountNo) REFERENCES Accounts (AccountNo)
   */
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
CREATE TABLE Organizations(
	OrgID varchar(20) NOT NULL,
	OrgName varchar(50) NULL,
	ParentOrgID varchar(20) NULL,
    PRIMARY KEY ( OrgID ASC )
);
*/
/*

CREATE TABLE ContactTypes(
	ContactType varchar(20) NOT NULL,
	PRIMARY KEY ( ContactType ASC )
);
*/


/*shouldnt elements have a unique name  - add uniqueness*/
/*
CREATE TABLE Elements(
	ElementId bigint(20) NOT NULL auto_increment,
	ElementName varchar(20) NULL,
    PRIMARY KEY ( ElementId ASC )
);

CREATE TABLE SchemaElements(
	SchemaElementId bigint(20) NOT NULL,
	SchemaId bigint(20) NULL,
	NaturalorAnalytics char(1) NULL,
	Sequence int NOT NULL,
	ElementId bigint NULL,
    PRIMARY KEY CLUSTERED ( SchemaElementId ASC)
);

*/
/*
CREATE TABLE AccountSchemas(
	SchemaId bigint(20) NOT NULL auto_increment,
	SchemaName varchar(50) NULL,
    PRIMARY KEY ( SchemaId ASC )
);
*/

