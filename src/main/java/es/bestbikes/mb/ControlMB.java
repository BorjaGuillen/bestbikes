/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.mb;

import es.bestbikes.bean.PeticionBean;
import es.bestbikes.jaxb.Filter;
import es.bestbikes.jaxb.Item;
import es.bestbikes.jaxb.Root;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author jorge
 */
@ManagedBean
public class ControlMB {
    
    private PeticionBean peticion;
    
    private List<Filter> filters;
    
    private Filter filter;

    private List<Item> items;
    
    private PeticionSrv srv = PeticionSrv.getInstance();

    public ControlMB() {
        srv = PeticionSrv.getInstance();
        
        String salida = srv.buscarCategorias();
        Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
        
        filters = xml.getFilter();
    }

    public PeticionBean getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionBean peticion) {
        this.peticion = peticion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
    
    
    
    
    public void buscar() {
        PeticionBean p = new PeticionBean();
        p.setUrl(Config.getInstance().get("b2b.url"));
        p.setLoginid(Config.getInstance().get("b2b.loginid"));
        p.setPassword(Config.getInstance().get("b2b.password"));
        p.setProcesstype(Config.getInstance().get("b2b.processtype"));
        p.setCategory(Config.getInstance().get("b2b.category"));
        p.setPagesize(Config.getInstance().get("b2b.pagesize"));
        p.setPage(Config.getInstance().get("b2b.page"));
        
        String salida = srv.buscar(p);
        
        Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
        items = xml.getItem();
        
        addMessage("Busqueda realizada!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    
}
