DROP TABLE `bestbike_bd`.`catPS_catSRV`;

CREATE TABLE `bestbike_bd`.`catPS_catSRV` (
  `idcatPS_catSRV` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT(10) NOT NULL,
  `categorykey` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idcatPS_catSRV`),
  UNIQUE INDEX `categorykey_UNIQUE` (`categorykey` ASC)
  );

-- inserciones de la relación

INSERT INTO `bestbike_bd`.`catPS_catSRV` (`id_categoria`, `categorykey`) VALUES ('184', 'ANHÄNGER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('181', 'BATTERIEBE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('241', 'BEKLEIDUNG');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('181', 'BELEUCHTUN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('210', 'BEREIFUNG');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('225', 'BREMSEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('252', 'BREMSHEBEL');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('252', 'BREMSZUBEH');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('183', 'COMPUTER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('246', 'E-BIKE-ZUB');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('273', 'EINRÄDER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('247', 'FELGEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('251', 'FELGENBÄND');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('186', 'FITNESS');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('254', 'FITNESS-ER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('255', 'FLICKZEUG/');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('226', 'GABELN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('266', 'GEPÄCKTRÄG');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('272', 'GLOCKEN/RA');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('196', 'GRIFFE/LEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('173', 'HELME');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('223', 'HR-DÄMPF.');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('193', 'KETTEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('267', 'KETTENSCHÜ');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('161', 'KINDERRÄDE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('161', 'KINDERSITZ');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('270', 'KLEINTEILE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('259', 'KÖRBE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('257', 'KÖRPERPFLE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('209', 'LAUFRÄDER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('227', 'LENKERBUEG');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('249', 'NABEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('253', 'PACKTASCHE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('228', 'PEDALE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('242', 'PFLEGEMITT');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('182', 'PUMPEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('232', 'SATTELSTÜT');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('262', 'SATTELÜBER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('243', 'SÄTTEL');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('233', 'SCHALTUNGE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('192', 'SCHLÄUCHE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('161', 'SCHLITTEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('256', 'SCHLÖSSER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('274', 'SCHUHE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('263', 'SCHUTZBLEC');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('261', 'SCHUTZHÜLL');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('245', 'SPEICHEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('260', 'SPIEGEL/WI');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('265', 'STÄNDER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('250', 'STEUERSÄTZ');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('269', 'STÜTZRÄDER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('185', 'TRANSPORTS');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('229', 'TRETLAGER');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('258', 'TRINKFLASC');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('230', 'VORBAUTEN');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('191', 'WERKZEUG');

INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('224', 'ZAHNKRÄNZE');
INSERT INTO `bestbike_bd`.`catPS_catSRV` ( `id_categoria`, `categorykey`) VALUES ('275', 'MARKETING');
