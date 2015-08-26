/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.wrapper;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.jpa.CargaProductos;
import es.bestbikes.util.Nvl;
import java.math.BigDecimal;

/**
 *
 * @author jorge
 */
public class WrapperItem {
    
    public static CargaProductos toLocal(ItemBean item) {
        CargaProductos salida = new CargaProductos();
        salida.setNumber(Nvl.toString(item.getNumber()));
        salida.setUnitprice(Nvl.toBigDecimal(item.getUnitprice()));
        salida.setScaledunitprice(BigDecimal.ZERO);
        salida.setRecommendedretailprice(Nvl.toBigDecimal(item.getRecommendedretailprice()));
        salida.setDescription1(Nvl.empty(item.getDescription1()));
        salida.setDescription2(Nvl.empty(item.getDescription2()));
        salida.setAvailablestatus(Nvl.toBoolean(item.getAvailablestatus()));
        salida.setAvailablestatusdesc(Nvl.empty(item.getAvailablestatusdesc()));
        salida.setSupplieritemnumber(Nvl.empty(item.getSupplieritemnumber()));
        salida.setTax(Nvl.toBigDecimal4Double(item.getTax()));
        salida.setEan(Nvl.empty(item.getEan()));
        salida.setManufacturerean(Nvl.empty(item.getManufacturerean()));
        salida.setCustomstariffnumber(Nvl.empty(item.getCustomstariffnumber()));
        salida.setSupplier(Nvl.empty(item.getSupplier()));
        salida.setCategorykey(Nvl.empty(item.getCategorykey()));
        salida.setInfourl(Nvl.empty(item.getInfourl()));
        salida.setPictureurl(Nvl.empty(item.getPictureurl()));
        
        return salida;
    }
    
}
