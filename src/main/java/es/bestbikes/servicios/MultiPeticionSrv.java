/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.servicios;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.control.bbdd.ProductoBBDD;
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
        /*int INC = 10;
        for (int r = 1; r <= nmpag;) {
            Robot robot = new Robot(r, r+INC);
            lista.add(robot);
            robot.start();
            r = r + INC + 1;
        }*/
        
        Robot robot = new Robot(1, nmpag);
        lista.add(robot);
        robot.start();

        while (!lista.isEmpty()) {
            esperarXsegundos(1);
        }
        
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
    
}
