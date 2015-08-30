/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jorge
 */
public class UtilImagen {
    
    
    public static void guardar(BufferedImage img, String nombre, int ancho, int alto) throws IOException {
        File file = new File(nombre);
        BufferedImage newImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.createGraphics();
        g.drawImage(img, 0, 0, ancho, alto, null);
        g.dispose();        
        ImageIO.write(newImage, "jpg", file);
    }
    
    public static String toPath(String codigo) {
        String salida = "/";
        for (int i = 0; i < codigo.length(); i++) {
            salida += codigo.charAt(i) + "/";
        }
        return salida;
    }
    
}
