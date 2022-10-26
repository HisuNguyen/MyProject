
CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `project`(`id`,`name`,`price`)
VALUES  ('1','iPhone 14','29999000' ),
		('2','iPhone 14 pro','39999000' ),
        ('3','iPhone 14 pro max','49999000' );
