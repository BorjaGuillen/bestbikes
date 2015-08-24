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
public class ReferenciaProductoRepetida extends Exception {
    private ReferenciaProductoRepetida() {
        super("Existen varios productos para la referencia indicada");
    }
    
    public ReferenciaProductoRepetida(String mensaje) {
        
        super(mensaje);
    }
    
}
