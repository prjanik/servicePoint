CREATE DATABASE  IF NOT EXISTS `services`;
USE `services`;

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
`id` int(11) NOT NULL auto_increment,
`country_name` varchar(45) NOT NULL default '',
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
-- 
-- Dumping data for table `country`
-- 

INSERT INTO `country` VALUES
        (1, 'China'),
        (2, 'France'),
        (3, 'Russian Federation');


DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
`id` int(11) NOT NULL auto_increment,
`city_name` varchar(45) NOT NULL default '',
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
-- 
-- Dumping data for table `city`
-- 

INSERT INTO `city` VALUES
        (1, 'Moscow'),
        (2, 'Tomsk'),
        (3, 'Omsk'),
    (4, 'Hong Kong'),
        (5, 'Yulin'),
        (6, 'Kaili'),
    (7, 'Paris'),
        (8, 'Marseille'),
        (9, 'Lyon');


DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id`  int(11) NOT NULL,
  `city_id`  int(11) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL default '',
  PRIMARY KEY (`id`),
  
  KEY FK_COUNTRY_idx (country_id),

  CONSTRAINT FK_COUNTRY
  FOREIGN KEY (country_id)
  REFERENCES country (id)

  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY FK_CITY_idx (city_id),

  CONSTRAINT FK_CITY
  FOREIGN KEY (city_id)
  REFERENCES city (id)

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `point`
--

INSERT INTO `point` VALUES 
	(1, 2, 7, '48  Square de la Couronne', 'point_1'),
	(2, 3, 1, '7  Nikolskaya street', 'point_2'),
	(3, 3, 2, '36  Smirnova street', 'point_3'),
	(4, 3, 3, '28/2 Koneva street ', 'point_4'),
	(5, 1, 4, '60 Wanchai Road', 'point_4');


    
DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `service`
-- 

INSERT INTO `service` VALUES 
	(1, 'Cashing'),
	(2, 'Payment'),
	(3, 'Transfer');


DROP TABLE IF EXISTS `point_service`;

CREATE TABLE `point_service` (
  `point_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  
  PRIMARY KEY (`point_id`,`service_id`),
  
  KEY `FK_POINT_idx` (`point_id`),
  
  CONSTRAINT `FK_POINT` FOREIGN KEY (`point_id`) 
  REFERENCES `point` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_SERVICE` FOREIGN KEY (`service_id`) 
  REFERENCES `service` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `point_service`
-- 

INSERT INTO `point_service` VALUES 
	(1, 1),
    (1, 2),
	(2, 3),
    (2, 1),
    (3, 1),
	(3, 3);

