/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.control.bbdd;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.exception.ControlBbddException;
import es.bestbikes.jpa.PsProduct;
import es.bestbikes.util.Trazas;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author isthar
 */
public class ProductoBBDD extends ControlBBDD{
    
    private static ProductoBBDD bbdd;
    
    private ProductoBBDD() {
        
    }
    
    public static ProductoBBDD getInstancia() {
        if (bbdd == null) {
            bbdd = new ProductoBBDD();
        }
        return bbdd;
    }
    
    
     public Integer insertarProductoNuevo(ItemBean productoNuevo)  throws ControlBbddException  {
        
        try {
            EntityManager em = getEntityManager();
            PsProduct producto= new PsProduct();
            
            producto.setDateAdd(Calendar.getInstance().getTime());
            producto.setDateUpd(null); 
            
            producto.setQuantity(1);
            producto.setActive(true);
            producto.setAdditionalShippingCost(BigDecimal.ZERO);
            producto.setAdvancedStockManagement(true);
            producto.setAvailableDate(null);
            producto.setAvailableForOrder(true);
            producto.setCacheDefaultAttribute(Integer.MIN_VALUE);
            producto.setCacheHasAttachments(true);
            producto.setCacheIsPack(true);
            producto.setCondition(null);
            producto.setCustomizable(Short.MIN_VALUE);
            producto.setDepth(BigDecimal.ZERO);
            producto.setEan13(null);
            producto.setEcotax(BigDecimal.ZERO);
            producto.setHeight(BigDecimal.ZERO);
            producto.setIdCategoryDefault(Integer.MIN_VALUE);
            
            producto.setIdManufacturer(Integer.MIN_VALUE);
            
            producto.setIdProductRedirected(0);
            producto.setIdShopDefault(0);
            producto.setOnlineOnly(true);
            producto.setIdSupplier(Integer.MIN_VALUE);
            producto.setIdTaxRulesGroup(0);
            producto.setIndexed(true);
            producto.setIsVirtual(true);
            producto.setLocation(null);
            producto.setMinimalQuantity(0);
            producto.setOnSale(false);
            producto.setOutOfStock(0);
            producto.setPackStockType(0);
            producto.setPrice(BigDecimal.ZERO);
            producto.setQuantity(0);
            producto.setQuantityDiscount(Boolean.TRUE);
            producto.setRedirectType(null);
            producto.setReference(null);
            producto.setShowPrice(false);
            producto.setSupplierReference(null);
            producto.setTextFields(Short.MIN_VALUE);
            producto.setUnitPriceRatio(BigDecimal.ZERO);
            producto.setUnity(null);
            producto.setUpc(null);
            producto.setUploadableFiles(Short.MIN_VALUE);
            producto.setVisibility(null);
            producto.setWeight(BigDecimal.ZERO);
            producto.setWholesalePrice(BigDecimal.ZERO);
            producto.setWidth(BigDecimal.ZERO);
            
            
            
            
            
                    
            
            
            
            
            
            
        } catch (Exception e) {
            Trazas.trazarError(e.getMessage());
            throw new  ControlBbddException ("error al insertar un producto en BD"+productoNuevo.toString());
        }
    
    return 1;
    
    }
     
    public Integer insertarListaProductos(List<ItemBean> listaProductos) throws ControlBbddException  {
        
        
        for (ItemBean productoNuevo : listaProductos){
            insertarProductoNuevo(productoNuevo);        
        }
        
        
    
    return 1;
    }
    
    
}
