/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.control.bbdd;

/**
 *
 * @author isthar
 */
public class ProductoBBDD extends ControlBBDD{
    
    private static ProductoBBDD bbdd;
    
    private ProductoBBDD() {
        
    }
    
    public static ProductoBBDD getInstancia() {
        if (bbdd == null) {
            bbdd = new ProductoBBDD();
        }
        return bbdd;
    }
    
    
    
    
}
