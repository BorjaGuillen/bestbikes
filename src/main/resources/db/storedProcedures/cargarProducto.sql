USE `bestbike_bd`;
DROP procedure IF EXISTS `cargarProducto`;

DELIMITER $$
USE `bestbike_bd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargarProducto`(
	IN incremento decimal(20,6), 
	IN actuarPVP tinyint(1),
	IN V_number varchar(200) ,
	IN V_supplier varchar(200), 
	IN V_supplieritemnumber varchar(200),
	IN V_categorykey varchar(200),
	IN V_recommendedretailprice decimal(20,6),
	IN V_unitprice decimal(20,6),
	IN V_availablestatus tinyint(1),
	IN V_description1 varchar(200),
	IN V_description2 varchar(200),
	IN V_infourl varchar(200),
	IN V_pictureurl varchar(200)
)
BEGIN

	DECLARE v_id_categoria int(10) DEFAULT -1;
	DECLARE v_id_marca int (10) DEFAULT 0;
	DECLARE v_id_product int (10) DEFAULT 0;
	DECLARE v_id_image int (10) DEFAULT 0;
	DECLARE v_descripcionLarga TEXT;
	DECLARE v_descripcionCorta TEXT;

	DECLARE v_error INTEGER DEFAULT 0;
	DECLARE aux_bucles INTEGER DEFAULT 0;
	DECLARE aux_integer INTEGER DEFAULT 0;
	DECLARE v_id_tax int(10) DEFAULT 1;
	DECLARE v_id_tax_rate decimal(10,3) DEFAULT 21;	



 -- Comprobamos si el producto es nuevo buscandolo en supplier_reference
 SELECT 'Comprobamos si el producto es nuevo buscandolo en supplier_reference';	
	select id_product from bestbike_bd.ps_product where supplier_reference=V_number INTO v_id_product;


-- Vemos cual es el id del fabricante correspondiente (supplier=id_manufacturer), en caos de que la marca no exista, la damos de alta
 SELECT 'Vemos cual es el id del fabricante correspondiente (supplier=id_manufacturer), en caos de que la marca no exista, la damos de alta';	
	select id_manufacturer from ps_manufacturer m where m.name=V_supplier into v_id_marca;
	select v_id_marca;
	IF v_id_marca=0 THEN 
 SELECT 'Creamos una nueva marca';
-- Creamos una nueva marca
		INSERT INTO bestbike_bd.ps_manufacturer (
				name,
				date_add,
				date_upd,
				active)
		VALUES (
				V_supplier, -- name,
				now(), -- date_add,
				'0000-00-00 00:00:00', -- date_upd,
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
						'', -- meta_title	varchar(128)
						'', -- meta_keywords	varchar(255)
						'' );-- meta_description	varchar(255)
			
			IF aux_bucles <3  THEN
			  ITERATE bucle;
			END IF; -- aux_bucles <3
			LEAVE bucle;
		END LOOP bucle; SET aux_bucles=0;


-- Insertamos en la tabla ps_manufacturer_shop la nueva marca:
		INSERT INTO bestbike_bd.ps_manufacturer_shop VALUES (v_id_marca,1);

	END IF; -- v_id_marca=0
/*
Obtemos el valor actual de impuestos con la id_tax 1 

*/

	select rate from ps_tax where id_tax=v_id_tax into v_id_tax_rate;

	

/*
	Calculamos el valor del producto, según vayamos a calcularlo en base al PVP o al precio de compra

*/
	SELECT 'Calculamos el valor del producto, según vayamos a calcularlo en base al PVP o al precio de compra';	

	IF actuarPVP=1 THEN -- Actuamos sobre el valor de de recommendedretailprice tomando el valor =recommendedretailprice+(recommendedretailprice*incremento)/100
			SET V_recommendedretailprice=V_recommendedretailprice+(V_recommendedretailprice*incremento)/100;
			SET V_recommendedretailprice=(V_recommendedretailprice*100)/(v_id_tax_rate+100);	
	ELSE   -- actuarPVP=0 Tenemos que insertar el elemento poniendo como valor de V_recommendedretailprice su valor unitprice+(unitprice*incremento)/100

			SET V_recommendedretailprice=V_unitprice+(V_unitprice*incremento)/100;

	END IF; -- actuarPVP=1

	
	/*
             Buscamos la categoria en la tabla de catPS_catRV, en caso de no encontrarla no cargamos el producto. 	
	*/

	select id_categoria from bestbike_bd.catPS_catSRV where categorykey=V_categorykey INTO v_id_categoria;
	

-- -----------------------------------------------------------------------------------------
	IF v_id_product=0 AND v_error=0 AND v_id_categoria!=-1 THEN -- Si el elemento no existe insertamos, siempre que tengamos categoría para el producto.

        SELECT 	'v_id_marca=',v_id_marca,
		'v_id_categoria=',v_id_categoria,
		'V_recommendedretailprice= ',V_recommendedretailprice,
		'V_supplieritemnumber= ',V_supplieritemnumber
		'V_number= ', V_number
		'V_availablestatus= ',V_availablestatus
		'sysdate= ', now();
	
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
					`condition`,
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
					1, -- id_supplier
					v_id_marca, -- id_manufacturer,
					v_id_categoria, -- id_category_default
					1, -- id_shop_default,
					1, -- id_tax_rules_group
					0, -- on_sale, CAMPO PARA OFERTAS
					0, -- online_only,
					'', -- ean13,
					'', -- upc,
					0, -- ecotax,
					0, -- quantity,
					1, -- minimal_quantity,
					V_recommendedretailprice, -- price,
					V_unitprice, -- wholesale_price,
					'', -- unity,
					0, -- unit_price_ratio,
					0, -- additional_shipping_cost,
					V_supplieritemnumber, -- reference,
					V_number, -- supplier_reference,
					'', -- location,
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
					V_availablestatus, -- available_for_order,
					'0000-00-00 00:00:00', -- available_date,
					'new',-- condition,
					1, -- show_price,
					0, -- indexed,
					'both', -- visibility,
					0, -- cache_is_pack,
					0, -- cache_has_attachments,
					0, -- is_virtual,
					0, -- cache_default_attribute,
					now(),-- date_add
					'0000-00-00 00:00:00', -- date_upd
					0, -- advanced_stock_management,
					3 -- pack_stock_type
					);


		select id_product from bestbike_bd.ps_product where supplier_reference=V_number INTO v_id_product;                    
		        
		INSERT INTO bestbike_bd.ps_product_shop (

                id_product,
                id_shop,
                id_category_default,
                id_tax_rules_group,
                on_sale,
                online_only,
                ecotax,
                minimal_quantity,
                price,
                wholesale_price,
                unity,
                unit_price_ratio,
                additional_shipping_cost,
                customizable,
                uploadable_files,
                text_fields,
                active,
                redirect_type,
                id_product_redirected,
                available_for_order,
                available_date,
                `condition`,
                show_price,
                indexed,
                visibility,
                cache_default_attribute,
                advanced_stock_management,
                date_add,
                date_upd,
                pack_stock_type
                    )

        VALUES (
                v_id_product, -- id_product    int(10) UN PK
                1, -- id_shop    int(10) UN PK
                v_id_categoria, -- id_category_default    int(10) UN
                1, -- id_tax_rules_group    int(11) UN
                0, -- on_sale    tinyint(1) UN
                0, -- online_only    tinyint(1) UN
                0, -- ecotax    decimal(17,6)
                1, -- minimal_quantity    int(10) UN
                V_recommendedretailprice, -- price    decimal(20,6)
                V_unitprice, -- wholesale_price    decimal(20,6)
                '', -- unity    varchar(255)
                0, -- unit_price_ratio    decimal(20,6)
                0, -- additional_shipping_cost    decimal(20,2)
                0, -- customizable    tinyint(2)
                0, -- uploadable_files    tinyint(4)
                0, -- text_fields    tinyint(4)
                V_availablestatus, -- active    tinyint(1) UN
                '404', -- redirect_type    enum('','404','301','302')
                0, -- id_product_redirected    int(10) UN
                1, -- available_for_order    tinyint(1)
                now(), -- available_date    date
                'new', -- condition    enum('new','used','refurbished')
                1, -- show_price    tinyint(1)
                1, -- indexed    tinyint(1)
                'both', -- visibility    enum('both','catalog','search','none')
                0, -- cache_default_attribute    int(10) UN
                0, -- advanced_stock_management    tinyint(1)
                now(), -- date_add    datetime
                now(), -- date_upd    datetime
                3 -- pack_stock_type    int(11) UN
                    );

                insert into ps_stock_available (
                    id_product,
                    id_product_attribute,
                    id_shop,
                    id_shop_group,
                    quantity,
                    depends_on_stock,
                    out_of_stock
                ) 
                VALUES (
                    v_id_product, -- id_product    int(11) UN
                    0, -- id_product_attribute    int(11) UN
                    1, -- id_shop    int(11) UN
                    0, -- id_shop_group    int(11) UN
                    10, -- quantity    int(10)
                    0, -- depends_on_stock    tinyint(1) UN
                    1 -- out_of_stock    tinyint(1) UN
                );					
			
			-- Cargamos las descripciones

	SELECT CONCAT('<p>',V_description1,'</p><p>',V_description2,'</p><p>',V_supplieritemnumber,'</p>') into v_descripcionCorta;
        SET v_descripcionLarga= v_descripcionCorta;-- V_infourl;

		SET aux_bucles=0;
		bucle: LOOP
			SET aux_bucles = aux_bucles + 1;
			INSERT INTO bestbike_bd.ps_product_lang (
						id_product,
						id_shop,
						id_lang,
						description,
						description_short,
						link_rewrite,
						meta_description,
						meta_keywords,
						meta_title,
						`name`,
						available_now,
						available_later) 
			VALUES (

					v_id_product, -- id_product	int(10) UN PK
					1, -- id_shop	int(11) UN PK
					aux_bucles, -- id_lang	int(10) UN PK
					v_descripcionLarga, -- description	text
					v_descripcionCorta, -- description_short	text
					'', -- link_rewrite	varchar(128)
					LEFT(V_description1,128), -- meta_description	varchar(255)
					LEFT(V_description1,128), -- meta_keywords	varchar(255)
					LEFT(V_description1,128), -- meta_title	varchar(128)
					LEFT(V_description1,128), -- name	varchar(128)
					'', -- available_now	varchar(255)
					'' -- available_later	varchar(255)
					);
			
			IF aux_bucles <3  THEN
			  ITERATE bucle;
			END IF; -- aux_bucles <3
			LEAVE bucle;
		END LOOP bucle; SET aux_bucles=0;

		-- Cargamos la categoría
	
		select IFNULL(MAX(p.position),0)+1 from bestbike_bd.ps_category_product p where p.id_category=v_id_categoria into aux_integer;

		IF aux_integer>0 THEN
		
				insert into bestbike_bd.ps_category_product(
					id_category,
					id_product,
					position)
				VALUES(
					v_id_categoria, -- id_category	int(10) UN PK
					v_id_product, -- id_product	int(10) UN PK
					aux_integer -- position	int(10) UN
				);
		END IF; -- aux_integer>0

-- Cargamos los datos de imagen



		insert into bestbike_bd.ps_image (
				id_product,
				position,
				cover) 
		VALUES (
				v_id_product, -- id_product	int(10) UN
				1, -- position	smallint(2) UN
				1 -- cover	tinyint(1) UN
		);

-- Recuperamos la variable de la imagen

		select id_image from bestbike_bd.ps_image where id_product=v_id_product INTO v_id_image;

		SET aux_bucles=0;
		bucle: LOOP
			SET aux_bucles = aux_bucles + 1;
			INSERT INTO bestbike_bd.ps_image_lang (
				id_image,
				id_lang,
				legend
			)
			VALUES (
				v_id_image, -- id_image	int(10) UN PK
				aux_bucles, -- id_lang	int(10) UN PK
				LEFT(V_description1,128) -- legend	varchar(128)
			);
			
			IF aux_bucles <3  THEN
			  ITERATE bucle;
			END IF; -- aux_bucles <3
			LEAVE bucle;
		END LOOP bucle; SET aux_bucles=0;

-- Insertamos en ps_image_shop
			INSERT INTO bestbike_bd.ps_image_shop (
                                id_product,
				id_image,
				id_shop,
				cover
			)
			VALUES (
                        v_id_product,	
			v_id_image, -- id_image	int(11) UN
				1, -- id_shop	int(11) UN
				1 -- cover	tinyint(1)
			);




			INSERT INTO bestbike_bd.ps_product_carrier (
				id_product, -- int(10) UN PK
				id_carrier_reference, -- int(10) UN PK
				id_shop-- int(10) UN PK
			)
			VALUES (
				v_id_product, -- id_product	int(10) UN PK
				3, -- id_carrier_reference	int(10) UN PK
				1 -- id_shop	int(10) UN PK
			);

	ELSE 
		IF v_id_categoria!=-1 THEN-- aux_count El elemento ya existia y vamos a actualizarlo. No cogemos las cartegorias -1 porque no hemos podido clasificarlo.

		
			update ps_product 
			SET price= V_recommendedretailprice,
                            active=V_availablestatus, 
                            date_upd=now(),
                            id_category_default=v_id_categoria                            
			WHERE id_product=v_id_product;
                        
                        update ps_product_shop 
			SET price= V_recommendedretailprice,
				active=V_availablestatus, 
				date_upd=now(),
                                id_category_default=v_id_categoria
			WHERE id_product=v_id_product;

                        update ps_category_product 
                        SET id_category=v_id_categoria
                        WHERE id_product=v_id_product;

		END IF; -- v_id_categoria!=-1
		

	END IF; -- v_id_product=0

-- actualizamos la fecha en la que hemos procesado el elemento a cargado

			update cargaProductos set fc_carga=now(), cargar=0
			where number=V_number;


END$$

DELIMITER ;