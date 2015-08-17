/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.test;

import es.bestbikes.bean.PeticionBean;
import es.bestbikes.jaxb.Root;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import org.junit.Test;



/**
 *
 * @author jorge
 */
public class PeticionSrvTest {
    
    @Test
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
    
    
}
