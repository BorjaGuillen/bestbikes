/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author jorge
 */
public class Nvl {

    public static String toString(BigInteger number) {
        String salida = null;
        if (number != null) {
            salida = number.toString();
        }
        return salida;
    }

    public static BigDecimal toBigDecimal(String unitprice) {
        BigDecimal salida = null;
        if (unitprice != null) {
            salida = new BigDecimal(unitprice.replaceAll(",", "."));
        }
        return salida;
    }

    public static boolean toBoolean(String availablestatus) {
        boolean salida = "0".equals(availablestatus);
        return salida;
    }

    public static BigDecimal toBigDecimal4Double(double tax) {
        BigDecimal salida = new BigDecimal(tax);
        return salida;
    }

    public static String empty(String dato) {
        if (dato == null) return "N.A.";
        return dato;
    }
    
    
}
