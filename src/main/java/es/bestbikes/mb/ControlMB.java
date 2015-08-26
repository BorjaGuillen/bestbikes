/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.mb;

import es.bestbikes.bean.FilterBean;
import es.bestbikes.bean.ItemBean;
import es.bestbikes.bean.PeticionBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
import es.bestbikes.servicios.MultiPeticionSrv;
import es.bestbikes.servicios.PeticionSrv;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class ControlMB implements Serializable {
    
    private PeticionBean peticion;
    
    private List<FilterBean> filters;
    
    private String filter;

    private List<ItemBean> items;
    
    private PeticionSrv srv = PeticionSrv.getInstance();
    
    private  List<String> marcas;

    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }
    
    private int porcentaje;

    @PostConstruct
    public void init() {
        srv = PeticionSrv.getInstance();
        filters = srv.buscarCategorias();
        porcentaje = 15;
        marcas = ProductoBBDD.getInstancia().listaMarcas();
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

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    public void buscar() {
        if (filter == null || "".equals(filter)) {
            addMessage("Seleccione una categoría");
        } else {
            long numitems = 0;
            for (Iterator<FilterBean> iterator = filters.iterator(); iterator.hasNext();) {
                FilterBean next = iterator.next();
                if (next.getFilterkey().equals(filter)) {
                    numitems = next.getFiltercount().longValue();
                }
            }
            items = srv.buscarItems(filter, numitems);
            addMessage("Busqueda realizada (" + filter + ")");
        }
    }
    
    public void actualizarDatos() {
        MultiPeticionSrv srv = MultiPeticionSrv.getInstance();
        srv.actualizarTodosLosItems();
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
    
    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public List<String> getMarcas() {
        return marcas;
    }


}

