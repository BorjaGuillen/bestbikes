/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.test;

import es.bestbikes.util.Nvl;
import es.bestbikes.util.Trazas;
import java.math.BigInteger;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class Prueba {

    @Test
    public void pruebaNvl(){
        Trazas.trazar(Nvl.toString(new BigInteger("123456")));
    }
}
