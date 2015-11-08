/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.servicios;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
import es.bestbikes.jpa.CargaProductos;
import es.bestbikes.types.TypeAtributos;
import es.bestbikes.util.Robot;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class MultiPeticionSrv {
    
    private static MultiPeticionSrv srv;
    
    private List<Robot> lista = new ArrayList<Robot>();

    private MultiPeticionSrv() {
        super();
    }

    public static MultiPeticionSrv getInstance() {
        if (srv == null) {
            srv = new MultiPeticionSrv();
        }
        return srv;
    }    
    
    public  void actualizarTodosLosItems() {
        ProductoBBDD.getInstancia().borrarTablaTemporal();
        PeticionSrv srv = PeticionSrv.getInstance();
        int nmpag = srv.obtenerTodosLosItemsNumpag();
        
        Robot robot = new Robot(1, nmpag);
        lista.add(robot);
        robot.start();

        while (!lista.isEmpty()) {
            esperarXsegundos(1);
        }
        
        solicitarAtributos();
    }
    
    public void eliminarRobot(Robot r) {
        lista.remove(r);
    }
    
    private void esperarXsegundos(int segundos) {
        try {
                Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
        }
    }    

    private void solicitarAtributos() {
        PeticionSrv srv = PeticionSrv.getInstance();
        ProductoBBDD bbdd = ProductoBBDD.getInstancia();

        TypeAtributos[] listaTA = TypeAtributos.values();
        for (TypeAtributos objTA : listaTA) {
            List<ItemBean> listaItems = srv.obtenerItemsPorAtributo(objTA);
            if (TypeAtributos.GANGAS == objTA || TypeAtributos.OFERTA_ESPECIAL == objTA) {
                for (ItemBean item : listaItems) {
                    bbdd.marcarOferta(item.getNumber());
                }
            } else {
                for (ItemBean item : listaItems) {
                    bbdd.actualizarCategoria(item.getNumber(), objTA);
                }
            }
        }
    }
    
}
