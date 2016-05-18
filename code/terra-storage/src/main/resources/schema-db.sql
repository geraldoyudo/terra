CREATE TABLE `account` (
  `accountNo` varchar(255) NOT NULL,
  `accountId` varchar(255) DEFAULT NULL,
  `alternateAccount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`accountNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `entry` (
  `entryId` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountNo` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `ccyAmount` decimal(19,2) DEFAULT NULL,
  `ccyCredit`  decimal(19,2) DEFAULT NULL,
  `ccyDebit` decimal(19,2) DEFAULT NULL,
  `credit`  decimal(19,2) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `debit`  decimal(19,2) DEFAULT NULL,
  `narrative` varchar(255) DEFAULT NULL,
  `rate` float NOT NULL,
  `transactionAnalysisCode` varchar(255) DEFAULT NULL,
  `orgId` varchar(255) DEFAULT NULL,
  `serialNo` varchar(255) DEFAULT NULL,
  `entryType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  KEY `orgId_serialNo_entryType` (`orgId`,`serialNo`,`entryType`),
  CONSTRAINT `orgId_serialNo_entryType` FOREIGN KEY (`orgId`, `serialNo`, `entryType`) REFERENCES `entryheader` (`orgId`, `serialNo`, `entryType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `entryheader` (
  `orgId` varchar(255) NOT NULL,
  `serialNo` varchar(255) NOT NULL,
  `entryType` varchar(255) NOT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedFromIP` varchar(255) DEFAULT NULL,
  `documentReference` varchar(255) DEFAULT NULL,
  `documentType` varchar(255) DEFAULT NULL,
  `entityCount` bigint(20) DEFAULT NULL,
  `entityHeaderId` varchar(255) DEFAULT NULL,
  `financialRecord` varchar(255) DEFAULT NULL,
  `financialYear` varchar(255) DEFAULT NULL,
  `postDate` datetime DEFAULT NULL,
  `postedBy` varchar(255) DEFAULT NULL,
  `postedFromIP` varchar(255) DEFAULT NULL,
  `postingRecord` varchar(255) DEFAULT NULL,
  `postingYear` varchar(255) DEFAULT NULL,
  `proofTotal` decimal(19,2) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `reviewedBy` varchar(255) DEFAULT NULL,
  `reviewedFromIP` varchar(255) DEFAULT NULL,
  `valueDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orgId`,`serialNo`,`entryType`),
  UNIQUE KEY `unique_entryHeaderId` (`entityHeaderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
