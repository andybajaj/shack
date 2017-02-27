USE `shack`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

insert into user(id,emailAddress,firstName,lastName,password,userName) values(1,'andy.bajajus@gmail.com','andy','bajaj','yyyy','andy.bajaj');
commit;