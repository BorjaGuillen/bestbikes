/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.mb;

import es.bestbikes.bean.FilterBean;
import es.bestbikes.bean.PeticionBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
import es.bestbikes.jpa.CargaProductos;
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
    
    private List<CargaProductos> items;
    
    private PeticionSrv srv = PeticionSrv.getInstance();
    
    private String[] selectedMarcas;

    private  List<String> marcas;

    private int porcentaje;
    
    @PostConstruct
    public void init() {
        srv = PeticionSrv.getInstance();
        //filters = srv.buscarCategorias();
        porcentaje = -10;
        marcas = ProductoBBDD.getInstancia().listaMarcas();
        buscar();
    }

    public PeticionSrv getSrv() {
        return srv;
    }

    public void setSrv(PeticionSrv srv) {
        this.srv = srv;
    }

    public PeticionBean getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionBean peticion) {
        this.peticion = peticion;
    }

    public List<CargaProductos> getItems() {
        return items;
    }

    public void setItems(List<CargaProductos> items) {
        this.items = items;
    }

    public List<FilterBean> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterBean> filters) {
        this.filters = filters;
    }

   
    public void buscar() {
        if (selectedMarcas == null || selectedMarcas.length == 0) {
            items = ProductoBBDD.getInstancia().buscarItems();
        } else {
            items = ProductoBBDD.getInstancia().buscarItems(selectedMarcas);
        }
    }
    
    public void actualizarDatos() {
        MultiPeticionSrv srv = MultiPeticionSrv.getInstance();
        srv.actualizarTodosLosItems();
    }
    
    
    public void marcarTodos() {
        for (Iterator<CargaProductos> iterator = items.iterator(); iterator.hasNext();) {
            CargaProductos next = iterator.next();
            next.setCargar(true);
        }
        addMessage("Artículos marcados");
    }
     
    public void desMarcarTodos() {
        for (Iterator<CargaProductos> iterator = items.iterator(); iterator.hasNext();) {
            CargaProductos next = iterator.next();
            next.setCargar(false);
        }
        addMessage("Artículos desmarcados");
    }

    public void cargarPvp() {
        boolean actuarPvp = true;
        ProductoBBDD.getInstancia().cargar(items, this.porcentaje, actuarPvp);
        buscar();
    }

    public void cargarPC() {
        boolean actuarPvp = false;
        ProductoBBDD.getInstancia().cargar(items, this.porcentaje, actuarPvp);
        buscar();
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

    public String[] getSelectedMarcas() {
        return selectedMarcas;
    }

    public void setSelectedMarcas(String[] selectedMarcas) {
        this.selectedMarcas = selectedMarcas;
    }

    
    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }
    
}

