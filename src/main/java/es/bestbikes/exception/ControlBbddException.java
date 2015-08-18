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
public class ControlBbddException extends Exception {
    
    private ControlBbddException() {
        super();
    }
    
    public ControlBbddException(String mensaje) {
        super(mensaje);
    }
    
}
