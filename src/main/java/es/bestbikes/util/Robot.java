/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.util;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
import es.bestbikes.jpa.CargaProductos;
import es.bestbikes.servicios.MultiPeticionSrv;
import es.bestbikes.servicios.PeticionSrv;
import es.bestbikes.wrapper.WrapperItem;
import java.sql.Wrapper;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Robot extends Thread {

    private int pagIni;
    
    private int pagFin;

    public Robot(int pagIni, int pagFin) {
        this.pagIni = pagIni;
        this.pagFin = pagFin;
    }
    
    @Override
    public void run() {
        Trazas.trazar("ROBOTILLO " + pagIni + " - " + pagFin + "Iniciando");
        for (int p = pagIni; p < pagFin; p++) {
            PeticionSrv srv = PeticionSrv.getInstance();
            List<ItemBean> salida = srv.obtenerTodosLosItems(p);
            for (Iterator<ItemBean> iterator = salida.iterator(); iterator.hasNext();) {
                ItemBean next = iterator.next();
                CargaProductos pro = WrapperItem.toLocal(next);
                ProductoBBDD.getInstancia().insertar(pro);
            }
        }
        MultiPeticionSrv.getInstance().eliminarRobot(this);
        Trazas.trazar("ROBOTILLO " + pagIni + " - " + pagFin + "Finalizado");
        
    }
    
}
