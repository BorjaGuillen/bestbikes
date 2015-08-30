USE `bestbike_bd`;
DROP procedure IF EXISTS `cargaProductos`;

DELIMITER $$
USE `bestbike_bd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargaProductos`(IN incremento decimal(20,6), actuarPVP tinyint(1))
BEGIN
	
	DECLARE V_number 					varchar(200) ;
	DECLARE V_unitprice					decimal(20,6) ;
	DECLARE V_scaledunitprice			decimal(20,6);
	DECLARE V_recommendedretailprice	decimal(20,6);
	DECLARE V_description1				varchar(200);
	DECLARE V_description2				varchar(200);
	DECLARE V_availablestatus			tinyint(1);
	DECLARE V_availablestatusdesc		varchar(200);
	DECLARE V_supplieritemnumber		varchar(200);
	DECLARE V_tax						decimal(17,6);
	DECLARE V_ean						varchar(13);
	DECLARE V_manufacturerean			varchar(200);
	DECLARE V_customstariffnumber		varchar(200);
	DECLARE V_supplier					varchar(200);
	DECLARE V_categorykey				varchar(200);
	DECLARE V_infourl					varchar(200);
	DECLARE V_pictureurl				varchar(200);

	DECLARE finished INTEGER DEFAULT 0;

	

	DECLARE ACargar CURSOR 
		FOR SELECT 
			number,
			unitprice,
			scaledunitprice,
			recommendedretailprice,
			description1,
			description2,
			availablestatus,
			availablestatusdesc,
			supplieritemnumber,
			tax,
			ean,
			manufacturerean,
			customstariffnumber,
			supplier,
			categorykey,
			infourl,
			pictureurl	
		from bestbike_bd.cargaProductos where cargar=1;


	DECLARE CONTINUE HANDLER
	 FOR NOT FOUND SET finished = 1; 
	


OPEN ACargar;

 get_registro: LOOP
 select finished 'fin:';

 FETCH ACargar INTO 
	V_number,
	V_unitprice,
	V_scaledunitprice,
	V_recommendedretailprice,
	V_description1,
	V_description2,
	V_availablestatus,
	V_availablestatusdesc,
	V_supplieritemnumber,
	V_tax,
	V_ean,
	V_manufacturerean,
	V_customstariffnumber,
	V_supplier,
	V_categorykey,
	V_infourl,
	V_pictureurl;



	 IF finished = 1 THEN 
		LEAVE get_registro;
	 END IF; -- finished = 1 
	
	CALL cargarProducto(incremento, actuarPVP,V_number,V_supplier,V_supplieritemnumber,V_categorykey,V_recommendedretailprice,V_unitprice,V_availablestatus);

 END LOOP get_registro;
 CLOSE ACargar;

SELECT 'FIN';	
END$$

DELIMITER ;

