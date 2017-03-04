-- Yogesh 03/04/2017
ALTER TABLE `shack`.`MemberMaster` 
ADD COLUMN `IsLeft` TINYINT NOT NULL DEFAULT 0 AFTER `MemberTypeID`;

CREATE TABLE `MemberAccount` (
  `MAID` int(11) NOT NULL AUTO_INCREMENT,
  `MMID` int(11) NOT NULL,
  `Password` varchar(500) NOT NULL,
  `LastLogin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CreatedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastUpdateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastPasswordReset` varchar(500) NOT NULL,
  `NoOfFailAttem` int(11) NOT NULL,
  `ResetPwdFailAttem` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`MAID`),
  KEY `MMID_idx` (`MMID`),
  CONSTRAINT `MMID` FOREIGN KEY (`MMID`) REFERENCES `MemberMaster` (`MMID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;