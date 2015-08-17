/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.servicios;

import es.bestbikes.bean.PeticionBean;
import es.bestbikes.util.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jorge
 */
public class PeticionSrv {

    private static PeticionSrv srv;

    private PeticionSrv() {
        super();
    }

    public static PeticionSrv getInstance() {
        if (srv == null) {
            srv = new PeticionSrv();
        }
        return srv;
    }

    
    public String buscarCategorias() {
        PeticionBean peticion = new PeticionBean();
        peticion.setUrl(Config.getInstance().get("b2b.url"));
        peticion.setLoginid(Config.getInstance().get("b2b.loginid"));
        peticion.setPassword(Config.getInstance().get("b2b.password"));
        peticion.setProcesstype(Config.getInstance().get("b2b.processtype"));
        peticion.setSearchpattern("*");
        
        return buscar(peticion);
    }
    
    public String buscar(PeticionBean peticion) {
        String salida = null;
        try {
            
            String urlstring = peticion.getUrl();
            urlstring += "?loginid=" + peticion.getLoginid();
            urlstring += "&password=" + peticion.getPassword();
            urlstring += "&processtype=" + peticion.getProcesstype();
            if (peticion.getCategory() != null) {
                urlstring += "&category=" + peticion.getCategory();
            }
            if (peticion.getPagesize() != null) {
                urlstring += "&pagesize=" + peticion.getPagesize();                    
            }
            if (peticion.getPage() != null) {
                urlstring += "&page=" + peticion.getPage();            
            }
            if (peticion.getSearchpattern() != null) {
                urlstring += "&searchpattern=*";            
            }

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            salida = "";
            while ((output = br.readLine()) != null) {
                salida += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return salida;
    }

}
