/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.mb;

import es.bestbikes.bean.FilterBean;
import es.bestbikes.bean.ItemBean;
import es.bestbikes.bean.PeticionBean;
import es.bestbikes.jaxb.Filter;
import es.bestbikes.jaxb.Item;
import es.bestbikes.jaxb.Root;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jorge
 */
@ManagedBean
@ViewScoped
public class ControlMB {
    
    private PeticionBean peticion;
    
    private List<FilterBean> filters;
    
    private FilterBean filter;

    private List<ItemBean> items;
    
    private PeticionSrv srv = PeticionSrv.getInstance();

    public ControlMB() {
        srv = PeticionSrv.getInstance();
        filters = srv.buscarCategorias();
    }

    public PeticionBean getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionBean peticion) {
        this.peticion = peticion;
    }

    public List<ItemBean> getItems() {
        return items;
    }

    public void setItems(List<ItemBean> items) {
        this.items = items;
    }

    public List<FilterBean> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterBean> filters) {
        this.filters = filters;
    }

    public FilterBean getFilter() {
        return filter;
    }

    public void setFilter(FilterBean filter) {
        this.filter = filter;
    }
    
    public void buscar() {
        items = srv.buscarItems();
        addMessage("Busqueda realizada!!");
    }
    
    
    public void marcarTodos() {
        items = srv.marcarTodos(items, true);
        addMessage("Artículos marcados");
    }
     
    public void desMarcarTodos() {
        items = srv.marcarTodos(items, false);
        addMessage("Artículos desmarcados");
    }

    public void cargar() {
        addMessage("Artículos cargados");
    }

    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    
    
    
}
