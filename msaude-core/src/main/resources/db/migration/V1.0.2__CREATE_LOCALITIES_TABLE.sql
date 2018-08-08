-- LOCALITIES --
CREATE TABLE `LOCALITIES` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CREATED_AT` DATETIME NOT NULL,
  `CREATED_BY` VARCHAR(50) NOT NULL,
  `ENTITY_STATUS` VARCHAR(15) NOT NULL,
  `UPDATED_AT` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(50) DEFAULT NULL,
  `UUID` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(30) NOT NULL,
  `PROVINCE_ID` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_LOCALITIES_PROVINCE_ID` (`PROVINCE_ID`),
  CONSTRAINT `FK_LOCALITIES_PROVINCE_ID` FOREIGN KEY (`PROVINCE_ID`) REFERENCES `PROVINCES` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;