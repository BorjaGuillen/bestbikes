ALTER TABLE `bestbike_bd`.`cargaProductos` 
CHANGE COLUMN `cargado` `cargar` TINYINT(1) NULL DEFAULT NULL ,
ADD COLUMN `Fc_carga` DATETIME NULL AFTER `cargar`;

