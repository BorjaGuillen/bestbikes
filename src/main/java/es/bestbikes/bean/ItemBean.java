/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.bean;

import es.bestbikes.jaxb.Item;

/**
 *
 * @author jorge
 */
public class ItemBean extends Item{
    
    private boolean cargar;

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
    
    
    
}
