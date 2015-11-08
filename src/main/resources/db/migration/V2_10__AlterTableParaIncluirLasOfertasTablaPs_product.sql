ALTER TABLE `bestbike_bd`.`cargaProductos` 
ADD COLUMN `En_oferta` TINYINT(1) NULL COMMENT 'Indicador de si el producto se debe incluir como en oferta al realizar la carga (ps_products.on_sale)' AFTER `Fc_carga`;
