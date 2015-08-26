/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.control.bbdd;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.exception.ControlBbddException;
import es.bestbikes.exception.ProductoExistente;
import es.bestbikes.exception.ReferenciaProductoRepetida;
import es.bestbikes.jpa.CargaProductos;
import es.bestbikes.jpa.PsProduct;
import es.bestbikes.util.Trazas;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    /**
     * Nos devuelve un ItemBean que contenga la referencia del proveedor que estamos buscando
     * @param referencia del proveerdor
     * @throws ReferenciaProductoRepetida en caso de que tengamos varios elementos con la misma referencia
     * @return ItemBean
     */
    public List<ItemBean> buscarProductos(String referencia) throws ReferenciaProductoRepetida{
        
        String sql ="SELECT p FROM PsProduct p WHERE p.supplierReference ="+referencia;
        Query q = getEntityManager().createQuery(sql);
        List<PsProduct> listaJpaq=q.getResultList();
        
        return null;
    }
    
    /**
     * <p>Metodo para insertar un producto nuevo, es decir que no existía previamente en el sistema de prestashop</p>
     * @param ItemBean que queremos cargar en prestashop
     * @throws ProductoExistente en caso de que el producto ya existiese en prestashop
     * @throws ControlBbddException en caso de no poder realizar la inserción en la BD por algún problema fuera del modelo de negocio.
     *  
    */
     private Integer insertarProductoNuevo(ItemBean productoNuevo)  throws ControlBbddException,ProductoExistente  {
                
         try {
            /*
            Comprobamos si el producto es nuevo buscandolo en supplier_reference
            */
            if (buscarProductos(productoNuevo.getSupplieritemnumber())!=null) 
                throw new ProductoExistente(productoNuevo.getSupplieritemnumber());    
            
            // En caso de no encontrarlo podemos dar de alta el nuevo elemento
            
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
            producto.setCacheHasAttachments(false);
            producto.setCacheIsPack(false);
            producto.setCondition("new");
            producto.setCustomizable(Short.MIN_VALUE);
            producto.setDepth(BigDecimal.ZERO);
            producto.setEan13(null);
            producto.setEcotax(BigDecimal.ZERO);
            producto.setHeight(BigDecimal.ZERO);
            
            /*Tendremos que asociar los códigos de catergoria que nos aporta el servicio web productoNuevo.getCategorykey();
             a los códigos de los que disponemos en prestaShopen (ps_category ps_category_lang). Una vez asociados asignaremos 
             el id correspondiente al IdCategoryDefault, en caso de no encontrarlo no cargamos al producto dando un error de 
             no existe la categoría xxx del producto a cargar.
            
            */
            producto.setIdCategoryDefault(Integer.MIN_VALUE);
            
            /*
              Calculamos quien es el fabricante, lo buscamos en la tabla de ps_manufacturer y lo asociamos.
              En caso de no exitir damos de alta el nuevo fabricante y asociamos su id al presente producto
            */
            producto.setIdManufacturer(Integer.MIN_VALUE);
            
            producto.setIdProductRedirected(0);
            producto.setIdShopDefault(0);
            producto.setOnlineOnly(true);
            producto.setIdSupplier(Integer.MIN_VALUE);
            producto.setIdTaxRulesGroup(0);
            producto.setIndexed(true);
            producto.setIsVirtual(true);
            producto.setLocation(null);
            producto.setMinimalQuantity(1);
            producto.setOnSale(false);
            producto.setOutOfStock(2);
            producto.setPackStockType(0);
            producto.setPrice(productoNuevo.getPrecioNuevo());
            producto.setQuantity(0);
            producto.setQuantityDiscount(Boolean.FALSE);
            producto.setRedirectType("404");
            producto.setReference(null);
            producto.setShowPrice(false);
            producto.setSupplierReference(null);
            producto.setTextFields(Short.MIN_VALUE);
            producto.setUnitPriceRatio(BigDecimal.ZERO);
            producto.setUnity(null);
            producto.setUpc(null);
            producto.setUploadableFiles(Short.MIN_VALUE);
            producto.setVisibility("both");
            producto.setWeight(BigDecimal.ZERO);
            producto.setWholesalePrice(BigDecimal.ZERO);
            producto.setWidth(BigDecimal.ZERO);
            
            
        } 
         
         catch (ProductoExistente e){
             Trazas.trazarWarning(e.getMessage());
                     
         }
         
         catch(ReferenciaProductoRepetida e){
         
         }
         
         catch (Exception e) {
            Trazas.trazarError(e.getMessage());
            throw new  ControlBbddException ("error al insertar un producto en BD"+productoNuevo.toString());
        }
    
    return 1;
    
    }
     
    public Integer insertarListaProductos(List<ItemBean> listaProductos) throws ControlBbddException  {
        
        Integer errores=0;
        
        for (ItemBean productoNuevo : listaProductos){
            try{
                insertarProductoNuevo(productoNuevo);        
            } 
            
            catch (ProductoExistente ex) {
                Trazas.trazarWarning("error al insertar un producto en BD"+ex.toString());
                errores++;
            }
            
            catch (Exception e) {
            Trazas.trazarError(e.getMessage());
            errores++;
            }
        }
        if (errores==listaProductos.size()) throw new  ControlBbddException ("No se han podido insertar ninguno de los productos.");
    
    return 1;
    }
    
    
    public List<String> listaMarcas() {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("SELECT distinct c.supplier FROM cargaProductos c");
        List<String> salida = query.getResultList();
        return salida;
    }
    
}
