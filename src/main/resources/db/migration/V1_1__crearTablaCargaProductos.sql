CREATE TABLE IF NOT EXISTS `cargaProductos2` (
  `number` varchar(200) NOT NULL,
  `unitprice` decimal(20,6) unsigned NOT NULL,
  `scaledunitprice` decimal(20,6) NOT NULL,
  `recommendedretailprice` decimal(20,6) NOT NULL,
  `description1` varchar(200) NOT NULL,
  `description2` varchar(200) NOT NULL,
  `availablestatus` tinyint(1) NOT NULL,
  `availablestatusdesc` varchar(200) NOT NULL,
  `supplieritemnumber` varchar(200) NOT NULL,
  `tax` decimal(17,6) NOT NULL,
  `ean` varchar(13) NOT NULL,
  `manufacturerean` varchar(200) NOT NULL,
  `customstariffnumber` varchar(200) NOT NULL,
  `supplier` varchar(200) NOT NULL,
  `categorykey` varchar(200) NOT NULL,
  `infourl` varchar(200) NOT NULL,
  `pictureurl` varchar(200) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

