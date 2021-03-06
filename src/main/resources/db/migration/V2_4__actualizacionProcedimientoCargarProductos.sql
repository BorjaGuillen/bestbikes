USE `bestbike_bd`;
DROP procedure IF EXISTS `cargaProductos`;

DELIMITER $$
USE `bestbike_bd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargaProductos`(IN incremento decimal(2,2), actuarPVP tinyint(1))
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

	DECLARE v_id_categoria int(10) DEFAULT 0;
	DECLARE v_id_marca int (10) DEFAULT 0;
	DECLARE v_id_product int (10) DEFAULT 0;

	DECLARE v_error INTEGER DEFAULT 0;
	DECLARE aux_bucles INTEGER DEFAULT 0;

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

 -- Comprobamos si el producto es nuevo buscandolo en supplier_reference
	
	select id_product from bestbike_bd.ps_product where supplier_reference=V_number INTO v_id_product;


-- Vemos cual es el id del fabricante correspondiente (supplier=id_manufacturer), en caos de que la marca no exista, la damos de alta

	select id_manufacturer from ps_manufacturer m where m.name=V_supplier into v_id_marca;
	
	IF v_id_marca=0 THEN 

-- Creamos una nueva marca
		INSERT INTO bestbike_bd.ps_manufacturer (
				name,
				date_add,
				date_upd,
				active)
		VALUES (
				V_supplier, -- name,
				now(), -- date_add,
				null, -- date_upd,
				1); -- active
		
-- Almacenamos en v_id_marca, el id autogenerado por la tabla ps_manufacturer al crear el registro de la nueva marca en la tabla.
		select id_manufacturer from ps_manufacturer m where m.name=V_supplier into v_id_marca;	
		
-- Insertamos en la tabla ps_manufacturer_lang tres registros para la descripción de los idiomas de la nueva marca.		
		SET aux_bucles=0;
		bucle: LOOP
			SET aux_bucles = aux_bucles + 1;
			INSERT INTO bestbike_bd.ps_manufacturer_lang (
						id_manufacturer,
						id_lang,
						description,
						short_description,
						meta_title,
						meta_keywords,
						meta_description) 
			VALUES (

						v_id_marca, -- id_manufacturer	int(10) UN PK
						aux_bucles, -- id_lang	int(10) UN PK
						V_supplier, -- description	text
						V_supplier, -- short_description	text
						null, -- meta_title	varchar(128)
						null, -- meta_keywords	varchar(255)
						null );-- meta_description	varchar(255)
			
			IF aux_bucles <4  THEN
			  ITERATE bucle;
			END IF; -- aux_bucles <4 
			LEAVE bucle;
		END LOOP bucle; SET aux_bucles=0;


-- Insertamos en la tabla ps_manufacturer_shop la nueva marca:

		INSERT INTO bestbike_bd.ps_manufacturer_shop VALUES (v_id_marca,1);

	END IF; -- v_id_marca=0

	

/*
	Calculamos el valor del producto, según vayamos a calcularlo en base al PVP o al precio de compra

*/


	IF actuarPVP=1 THEN -- Actuamos sobre el valor de de recommendedretailprice tomando el valor =recommendedretailprice+(recommendedretailprice*incremento)/100
		
			SET V_recommendedretailprice=V_recommendedretailprice+(V_recommendedretailprice*incremento)/100;
	
	ELSEIF v_error=0 THEN -- actuarPVP=0 Tenemos que insertar el elemento poniendo como valor de V_recommendedretailprice su valor unitprice+(unitprice*incremento)/100

			SET V_recommendedretailprice=V_unitprice+(V_unitprice*incremento)/100;

	END IF; -- actuarPVP=1

	
	/*
		 Tendremos que asociar los códigos de catergoria que nos aporta el servicio web productoNuevo.getCategorykey();
		 a los códigos de los que disponemos en prestaShopen (ps_category ps_category_lang). Una vez asociados asignaremos 
		 el id correspondiente al IdCategoryDefault, en caso de no encontrarlo no cargamos al producto dando un error de 
		 no existe la categoría xxx del producto a cargar.
	
	*/
	select id_categoria from bestbike_bd.catPS_catSRV where categorykey=V_categorykey INTO v_id_categoria;
	


-- -----------------------------------------------------------------------------------------
	IF v_id_product=0 AND v_error=0 THEN -- Si el elemento no existe insertamos

		INSERT INTO bestbike_bd.ps_product (

					id_supplier,
					id_manufacturer,
					id_category_default,
					id_shop_default,
					id_tax_rules_group,
					on_sale,
					online_only,
					ean13,
					upc,
					ecotax,
					quantity,
					minimal_quantity,
					price,
					wholesale_price,
					unity,
					unit_price_ratio,
					additional_shipping_cost,
					reference,
					supplier_reference,
					location,
					width,
					height,
					depth,
					weight,
					out_of_stock,
					quantity_discount,
					customizable,
					uploadable_files,
					text_fields,
					active,
					redirect_type,
					id_product_redirected,
					available_for_order,
					available_date,
					-- condition,
					show_price,
					indexed,
					visibility,
					cache_is_pack,
					cache_has_attachments,
					is_virtual,
					cache_default_attribute,
					date_add,
					date_upd,
					advanced_stock_management,
					pack_stock_type
					)

		VALUES (
					0, -- id_supplier
					v_id_marca, -- id_manufacturer,
					v_id_categoria, -- id_category_default
					1, -- id_shop_default,
					1, -- id_tax_rules_group,
					1, -- on_sale,
					0, -- online_only,
					null, -- ean13,
					null, -- upc,
					0, -- ecotax,
					0, -- quantity,
					1, -- minimal_quantity,
					V_recommendedretailprice, -- price,
					0, -- wholesale_price,
					null, -- unity,
					0, -- unit_price_ratio,
					0, -- additional_shipping_cost,
					V_supplieritemnumber, -- reference,
					V_number, -- supplier_reference,
					null, -- location,
					0, -- width,
					0, -- height,
					0, -- depth,
					0, -- weight,
					2, -- out_of_stock,
					0, -- quantity_discount,
					0, -- customizable,
					0, -- uploadable_files,
					0, -- text_fields,
					V_availablestatus, -- active,
					'404', -- redirect_type,
					0, -- id_product_redirected,
					1, -- available_for_order,
					null, -- available_date,
					'new',-- condition,
					1, -- show_price,
					0, -- indexed,
					'both', -- visibility,
					0, -- cache_is_pack,
					0, -- cache_has_attachments,
					0, -- is_virtual,
					0, -- cache_default_attribute,
					now(),-- date_add
					null, -- date_upd
					0, -- advanced_stock_management,
					3 -- pack_stock_type
					);
					
			-- actualizamos la fecha en la que hjemos procesado el elemento a cargado
					update cargaProductos set fc_carga=now() where number=V_number;
			-- Cargamos las descripciones

	ELSE -- aux_count El elemento ya existia y vamos a actualizarlo

		update ps_product 
		SET price= V_recommendedretailprice,
			active=V_availablestatus, 
			date_upd=now()
		WHERE id_product=v_id_product;

	END IF; -- v_id_product=0

 END LOOP get_registro;
 CLOSE ACargar;
END$$

DELIMITER ;



