GO

/****** Object:  Table [dbo].[AccountMap]    Script Date: 09/15/2016 09:21:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AccountMap](
	[OrgId] [varchar](20) NULL,
	[LedgerCode] [varchar](10) NULL,
	[CcyCode] [varchar](10) NULL,
	[NaturalAccount] [varchar](10) NULL,
	[BPId] [varchar](50) NULL,
	[ProductCode] [varchar](10) NULL,
	[ProjectCode] [varchar](10) NULL,
	[LocationCode] [varchar](10) NULL,
	[CampaignCode] [varchar](10) NULL,
	[ActivityCode] [varchar](10) NULL,
	[AnalysisAccountNo] [varchar](max) NULL,
	[AccountAlias] [varchar](50) NULL,
	[AltAccountNo] [varchar](50) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO



GO

/****** Object:  Table [dbo].[Accounts]    Script Date: 09/15/2016 09:22:16 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Accounts](
	[AccountNo] [varchar](50) NOT NULL,
	[Name] [varchar](50) NULL,
	[Description] [varchar](max) NULL,
	[isActive] [bit] NULL,
	[isSummary] [bit] NULL,
	[AccountSign] [char](1) NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[AccountNo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[AccountSchemas]    Script Date: 09/15/2016 09:22:27 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AccountSchemas](
	[SchemaId] [bigint] NOT NULL,
	[SchemaName] [varchar](50) NULL,
 CONSTRAINT [PK_AccountSchemas] PRIMARY KEY CLUSTERED 
(
	[SchemaId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[AccountTypes]    Script Date: 09/15/2016 09:22:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AccountTypes](
	[AcctTypeCode] [char](1) NOT NULL,
	[AcctType] [varchar](50) NULL,
 CONSTRAINT [PK_AcctTypes] PRIMARY KEY CLUSTERED 
(
	[AcctTypeCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[Addresses]    Script Date: 09/15/2016 09:22:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Addresses](
	[AddressId] [bigint] NOT NULL,
	[Line_1] [varchar](50) NULL,
	[Line_2] [varchar](50) NULL,
	[Line_3] [varchar](50) NULL,
	[City] [varchar](50) NULL,
	[County] [varchar](50) NULL,
	[ZipCode] [varchar](10) NULL,
	[State] [varchar](50) NULL,
	[CountryCode] [varchar](10) NULL,
	[AddrCheckStatus] [varchar](10) NULL,
	[AddrCheckDate] [date] NULL,
 CONSTRAINT [PK_Addresses] PRIMARY KEY CLUSTERED 
(
	[AddressId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[BusinessPartnerRoles]    Script Date: 09/15/2016 09:23:01 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[BusinessPartnerRoles](
	[BPId] [bigint] NOT NULL,
	[Role] [varchar](20) NOT NULL,
	[BPIDRoleID] [varchar](50) NULL,
 CONSTRAINT [PK_BusinessPartnerRoles] PRIMARY KEY CLUSTERED 
(
	[BPId] ASC,
	[Role] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[BusinessPartnerRoles]  WITH CHECK ADD  CONSTRAINT [FK_BusinessPartnerRoles_BusinessPartners] FOREIGN KEY([BPId])
REFERENCES [dbo].[BusinessPartners] ([BPId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[BusinessPartnerRoles] CHECK CONSTRAINT [FK_BusinessPartnerRoles_BusinessPartners]
GO

ALTER TABLE [dbo].[BusinessPartnerRoles]  WITH CHECK ADD  CONSTRAINT [FK_BusinessPartnerRoles_Roles] FOREIGN KEY([Role])
REFERENCES [dbo].[Roles] ([Role])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[BusinessPartnerRoles] CHECK CONSTRAINT [FK_BusinessPartnerRoles_Roles]
GO


GO

/****** Object:  Table [dbo].[BusinessPartners]    Script Date: 09/15/2016 09:23:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[BusinessPartners](
	[BPId] [bigint] IDENTITY(1,1) NOT NULL,
	[CustomerNo] [varchar](10) NULL,
	[VendorNo] [varchar](10) NULL,
	[StaffNo] [varchar](10) NULL,
	[Name] [varchar](50) NULL,
	[FirstName] [varchar](50) NULL,
	[OtherNames] [varchar](50) NULL,
 CONSTRAINT [PK_BusinessPartners] PRIMARY KEY CLUSTERED 
(
	[BPId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[Contacts]    Script Date: 09/15/2016 09:23:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Contacts](
	[ContactId] [bigint] NOT NULL,
	[BPId] [bigint] NULL,
	[isActive] [bit] NULL,
	[Name] [varchar](50) NULL,
	[FirstName] [varchar](50) NULL,
	[OtherNames] [varchar](50) NULL,
	[TitleofCourtesy] [varchar](50) NULL,
	[ContactPhoto] [image] NULL,
	[Salutation] [varchar](50) NULL,
	[Department] [varchar](50) NULL,
	[Designation] [varchar](50) NULL,
	[DateofBirth] [date] NULL,
	[BVN] [varchar](50) NULL,
	[Religion] [varchar](50) NOT NULL,
	[BirthdayGreetings] [bit] NULL,
	[ChristmasGreetings] [bit] NULL,
	[OfficePhone1] [varchar](20) NULL,
	[OfficePhone2] [varchar](20) NULL,
	[OfficePhoneExt] [varchar](10) NULL,
	[HousePhone] [varchar](20) NULL,
	[MobilePhone1] [varchar](20) NULL,
	[MobilePhone1Status] [varchar](20) NULL,
	[MobilePhone2] [varchar](20) NULL,
	[MobilePhone2Status] [varchar](20) NULL,
	[eMailAddress] [varchar](50) NULL,
	[eMailAddress2] [varchar](50) NOT NULL,
	[skypeAddress] [varchar](50) NULL,
	[LinkedInAddress] [varchar](50) NULL,
	[TwitterHandle] [varchar](50) NULL,
	[FaceBookId] [varchar](50) NULL,
	[PreferredLanguage] [varchar](20) NULL,
 CONSTRAINT [PK_Contacts] PRIMARY KEY CLUSTERED 
(
	[ContactId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[ContactTypes]    Script Date: 09/15/2016 09:23:43 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[ContactTypes](
	[ContactType] [varchar](20) NOT NULL,
 CONSTRAINT [PK_ContactTypes] PRIMARY KEY CLUSTERED 
(
	[ContactType] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[Currencys]    Script Date: 09/15/2016 09:23:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Currencys](
	[CcyId] [bigint] IDENTITY(1,1) NOT NULL,
	[CcyCode] [varchar](10) NULL,
	[CcyName] [varchar](10) NULL,
	[CcySymbol] [varchar](10) NULL,
	[ISOCode] [varchar](10) NULL,
	[isBaseCCY] [bit] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_Currencys] PRIMARY KEY CLUSTERED 
(
	[CcyId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[CustomerAddresses]    Script Date: 09/15/2016 09:24:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CustomerAddresses](
	[CustomerAddressId] [bigint] IDENTITY(1,1) NOT NULL,
	[BPId] [bigint] NULL,
	[AddressId] [bigint] NULL,
	[AddrTypeCode] [nchar](10) NULL,
	[AddrFromDate] [date] NULL,
	[AddrThruDate] [date] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_CustomerAddresses] PRIMARY KEY CLUSTERED 
(
	[CustomerAddressId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[CustomerAddresses]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddresses_Addresses] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Addresses] ([AddressId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[CustomerAddresses] CHECK CONSTRAINT [FK_CustomerAddresses_Addresses]
GO

ALTER TABLE [dbo].[CustomerAddresses]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddresses_BusinessPartners] FOREIGN KEY([BPId])
REFERENCES [dbo].[BusinessPartners] ([BPId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[CustomerAddresses] CHECK CONSTRAINT [FK_CustomerAddresses_BusinessPartners]
GO


GO

/****** Object:  Table [dbo].[Elements]    Script Date: 09/15/2016 09:24:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Elements](
	[ElementId] [bigint] IDENTITY(1,1) NOT NULL,
	[ElementName] [varchar](20) NULL,
 CONSTRAINT [PK_Elements] PRIMARY KEY CLUSTERED 
(
	[ElementId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[Ledgers]    Script Date: 09/15/2016 09:24:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Ledgers](
	[LedgerCode] [varchar](10) NOT NULL,
	[LedgerDescription] [varchar](50) NULL,
	[AccountType] [char](1) NULL,
 CONSTRAINT [PK_Ledgers] PRIMARY KEY CLUSTERED 
(
	[LedgerCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Ledgers]  WITH CHECK ADD  CONSTRAINT [FK_Ledgers_AccountTypes] FOREIGN KEY([AccountType])
REFERENCES [dbo].[AccountTypes] ([AcctTypeCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Ledgers] CHECK CONSTRAINT [FK_Ledgers_AccountTypes]
GO


GO

/****** Object:  Table [dbo].[Organizations]    Script Date: 09/15/2016 09:25:03 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Organizations](
	[OrgID] [varchar](20) NOT NULL,
	[OrgName] [varchar](50) NULL,
	[ParentOrgID] [varchar](20) NULL,
 CONSTRAINT [PK_Organizations] PRIMARY KEY CLUSTERED 
(
	[OrgID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[RefAddressTypes]    Script Date: 09/15/2016 09:25:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[RefAddressTypes](
	[AddrTypeCode] [varchar](10) NOT NULL,
	[AddrTypeDescription] [varchar](50) NULL,
 CONSTRAINT [PK_RefAddressTypes] PRIMARY KEY CLUSTERED 
(
	[AddrTypeCode] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[Roles]    Script Date: 09/15/2016 09:25:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Roles](
	[Role] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Role] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


GO

/****** Object:  Table [dbo].[SchemaElements]    Script Date: 09/15/2016 09:25:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[SchemaElements](
	[SchemaElementId] [bigint] NOT NULL,
	[SchemaId] [bigint] NULL,
	[NaturalorAnalytics] [char](1) NULL,
	[Sequence] [int] NOT NULL,
	[ElementId] [bigint] NULL,
 CONSTRAINT [PK_SchemaElements] PRIMARY KEY CLUSTERED 
(
	[SchemaElementId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO