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
import es.bestbikes.jpa.PsImage;
import es.bestbikes.jpa.PsImageType;
import es.bestbikes.jpa.PsProduct;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.util.Config;
import es.bestbikes.util.Trazas;
import es.bestbikes.util.UtilImagen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
        Query query = em.createNativeQuery("SELECT distinct c.supplier FROM cargaProductos c ORDER BY c.supplier");
        List<String> salida = query.getResultList();
        return salida;
    }

    public void insertar(CargaProductos pro) {
        EntityManager em = getEntityManager(); 
        try {
            em.getTransaction().begin();
            em.persist(pro);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

    }
    
    public void borrarTablaTemporal() {
        EntityManager em = getEntityManager(); 
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM CargaProductos").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void cargar(List<CargaProductos> items, int porcentaje, boolean actuarPvp) {
        EntityManager em = getEntityManager(); 
        try {
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            Query query = em.createNativeQuery("{call cargaProductos(?, ?)}");  
            query.setParameter(1, porcentaje);
            query.setParameter(2, actuarPvp);
            query.executeUpdate();
            em.getTransaction().commit();
            
            // Crear imagenes
            Query query3 = em.createNamedQuery("PsImageType.findAll");  
            List<PsImageType> tiposImg = query3.getResultList();
            String rutaImagenes = Config.getInstance().get("b2b.rutaimg");
            for (Iterator<CargaProductos> iterator = items.iterator(); iterator.hasNext();) {
                CargaProductos next = iterator.next();
                if (next.getCargar()) {
                    String codigo = next.getNumber();
                    String numeroImagen = obtenerNumeroImagen(codigo);
                    if (numeroImagen != null) {
                        String nombreImagen = numeroImagen + ".jpg";
                        String pathImagen = UtilImagen.toPath(numeroImagen);
                        if (!new File(rutaImagenes + pathImagen).exists()) {
                            File dir = new File(rutaImagenes + pathImagen);
                            dir.mkdirs();
                        }
                        BufferedImage img = null;
                        int numMaxReintentos = Integer.parseInt(Config.getInstance().get("b2b.reintentos"));
                        int reintentos = 0;
                        while (img == null && reintentos < numMaxReintentos) {
                            reintentos++;
                            img = PeticionSrv.getInstance().obtenerImagen(next.getPictureurl());    
                        }
                        if (img != null) {
                            UtilImagen.guardar(img, rutaImagenes + pathImagen + nombreImagen, img.getWidth(), img.getHeight());
                            for (Iterator<PsImageType> itr1 = tiposImg.iterator(); itr1.hasNext();) {
                                PsImageType imgType = itr1.next();
                                nombreImagen = numeroImagen + "-" + imgType.getName() + ".jpg";
                                UtilImagen.guardar(img, rutaImagenes + pathImagen + nombreImagen, imgType.getWidth(), imgType.getHeight());
                            }
                        } else {
                            Trazas.trazar("Number: " + next.getNumber() 
                                        + "Nombre:" + nombreImagen 
                                        + "URL: " + next.getPictureurl());
                        }
                    }
                }
            }

        } catch (Exception e) {
            Trazas.trazarError(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        
    }

    public List<CargaProductos> buscarItems(String[] selectedMarcas) {
        List<CargaProductos> lista = new ArrayList<CargaProductos>();
        EntityManager em = getEntityManager(); 
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            String par = "'" + selectedMarcas[0] + "'";
            for (int i = 1; i < selectedMarcas.length; i++) {
                par += ", '" + selectedMarcas[i] + "'";
            }
            
            Query q = em.createQuery("SELECT c FROM CargaProductos c WHERE c.supplier in (" + par + ")");
            lista = q.getResultList();
        } catch (Exception e) {
            Trazas.trazar(e.getMessage());
        }
        return lista;
    }

    public List<CargaProductos> buscarItems() {
        List<CargaProductos> lista = new ArrayList<CargaProductos>();
        EntityManager em = getEntityManager(); 
        em.clear();
        em.getEntityManagerFactory().getCache().evictAll();
        try {
            Query q = em.createNamedQuery("CargaProductos.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    private String obtenerNumeroImagen(String codigo) {
        String salida = null;
        EntityManager em = getEntityManager(); 
        try {
            Query q = em.createQuery("SELECT p.idProduct FROM PsProduct p WHERE p.supplierReference = :supplierReference");
            q.setParameter("supplierReference", codigo);
            Integer idproduct = (Integer) q.getSingleResult();
            
            Query q2 = em.createNamedQuery("PsImage.findByIdProduct");
            q2.setParameter("idProduct", idproduct);
            PsImage pimg = (PsImage) q2.getSingleResult();
            
            salida = pimg.getIdImage() + "";
            
        } catch (Exception e) {
            Trazas.trazar(e.getMessage());
            salida = null;
        }
        return salida;
    }


    /*                
                PsProduct
                PsImage
                PsImageType        
            */

}
