/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.test;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.bean.PeticionBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
import es.bestbikes.jaxb.Root;
import es.bestbikes.jpa.CargaProductos;
import es.bestbikes.servicios.MultiPeticionSrv;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import es.bestbikes.wrapper.WrapperItem;
import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;



/**
 *
 * @author jorge
 */
public class PeticionSrvTest {
    
    @Test
    @Ignore
    public void buscar() {
        PeticionSrv srv = PeticionSrv.getInstance();
        
        PeticionBean p = new PeticionBean();
        p.setUrl(Config.getInstance().get("b2b.url"));
        p.setLoginid(Config.getInstance().get("b2b.loginid"));
        p.setPassword(Config.getInstance().get("b2b.password"));
        p.setProcesstype(Config.getInstance().get("b2b.processtype"));
        p.setCategory(Config.getInstance().get("b2b.category"));
        p.setPagesize(Config.getInstance().get("b2b.pagesize"));
        p.setPage(Config.getInstance().get("b2b.page"));
        
        String salida = srv.buscar(p);
        System.out.println(salida);
        
        Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
        System.out.println(xml.getGUID());
    }
    
    
    @Test
    @Ignore
    public void pedirTodo() {
        PeticionSrv srv = PeticionSrv.getInstance();
        List<ItemBean> salida = srv.obtenerTodosLosItems();
        System.out.println("He obtenido " + salida.size() + " items");
    }
    
    @Test
    @Ignore
    public void actualizarTodo() {
        MultiPeticionSrv srv = MultiPeticionSrv.getInstance();
        srv.actualizarTodosLosItems();
    }
    
    @Test
    @Ignore
    public void probarTripasRobot() {
            PeticionSrv srv = PeticionSrv.getInstance();
            ProductoBBDD.getInstancia().borrarTablaTemporal();
            List<ItemBean> salida = srv.obtenerTodosLosItems(1);
            for (Iterator<ItemBean> iterator = salida.iterator(); iterator.hasNext();) {
                ItemBean next = iterator.next();
                CargaProductos pro = WrapperItem.toLocal(next);
                ProductoBBDD.getInstancia().insertar(pro);
            }
    }
    
}
