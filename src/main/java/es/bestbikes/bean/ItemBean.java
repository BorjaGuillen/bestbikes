/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.bean;

import es.bestbikes.jaxb.Item;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author jorge
 */
public class ItemBean extends Item implements Serializable {
    
    private boolean cargar;
   /**
    * <p> Precio del producto a cargar, tras haber sido modificado con el incremento que desea el usuario.</p>
    */    
    private BigDecimal precioNuevo;

    public ItemBean(Item next) {
        this.number = next.getNumber();
        this.unitprice = next.getUnitprice();
        this.scaledunitprice = next.getScaledunitprice();
        this.recommendedretailprice = next.getRecommendedretailprice();
        this.description1 = next.getDescription1();
        this.description2 = next.getDescription2();
        this.availablestatus = next.getAvailablestatus();
        this.availablestatusdesc = next.getAvailablestatusdesc();
        this.supplieritemnumber = next.getSupplieritemnumber();
        this.tax = next.getTax();
        this.ean = next.getEan();
        this.manufacturerean = next.getManufacturerean();
        this.customstariffnumber = next.getCustomstariffnumber();
        this.supplier = next.getSupplier();
        this.categorykey = next.getCategorykey();
        this.infourl = next.getInfourl();
        this.pictureurl = next.getPictureurl();
        this.cargar = true;
    }

    public boolean isCargar() {
        return cargar;
    }

    public void setCargar(boolean cargar) {
        this.cargar = cargar;
    }
    
     public void setPrecioNuevo(BigDecimal precioNuevo) {
        this.precioNuevo = precioNuevo;
    }

    public BigDecimal getPrecioNuevo() {
        return precioNuevo;
    }
    
    
    
}
