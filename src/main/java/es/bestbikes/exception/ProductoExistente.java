/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.exception;

/**
 *
 * @author isthar
 */
public class ProductoExistente extends Exception {
    
    private ProductoExistente() {
        super("El producto que se intenta cargar en el sistema como nuevo, ya existe en prestashop, intentad utilizar para este producto el método de acutalización");
    }
    
    public ProductoExistente(String mensaje) {
        
        super(mensaje);
    }
 
}
