CREATE TABLE `bestbike_bd`.`catPS_catSRV` (
  `idcatPS_catSRV` INT NOT NULL,
  `id_categoria` INT(10) UNSIGNED NOT NULL COMMENT 'id de la categoría en prestashop',
  `categorykey` VARCHAR(200) NOT NULL COMMENT 'Identificador único de la catergoría del producto por el servicio web proveedor',
  PRIMARY KEY (`idcatPS_catSRV`),
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC),
  UNIQUE INDEX `categorykey_UNIQUE` (`categorykey` ASC),
  CONSTRAINT `fk_catPS_catSRV_1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `bestbike_bd`.`ps_category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
