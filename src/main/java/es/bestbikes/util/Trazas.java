/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.util;

import org.apache.log4j.Logger;

/**
 *
 * @author isthar
 * TODO conectar con algo tipo log4j
 */
public class Trazas {
    
         
    public static void trazar(String mensaje) {
        Logger log = Logger.getLogger("Logger-bestbike");
        log.debug(mensaje);
        
        System.out.println(mensaje);
    }
     public static void trazarWarning(String mensaje) {
        Logger log = Logger.getLogger("Logger bestbike");
        log.warn(mensaje);
        
        System.out.println("Aviso: " + mensaje);
    }
    
    public static void trazarError(String mensaje) {
        Logger log = Logger.getLogger("Logger bestbike");
        log.error(mensaje);
        
        System.out.println("Error: "+mensaje);
    }
   
}
