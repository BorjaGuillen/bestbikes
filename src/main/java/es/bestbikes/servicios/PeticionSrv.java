/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.servicios;

import es.bestbikes.bean.FilterBean;
import es.bestbikes.bean.ItemBean;
import es.bestbikes.bean.PeticionBean;
import es.bestbikes.jaxb.Filter;
import es.bestbikes.jaxb.Item;
import es.bestbikes.jaxb.Root;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    
    public List<FilterBean> buscarCategorias() {
        PeticionBean peticion = new PeticionBean();
        peticion.setUrl(Config.getInstance().get("b2b.url"));
        peticion.setLoginid(Config.getInstance().get("b2b.loginid"));
        peticion.setPassword(Config.getInstance().get("b2b.password"));
        peticion.setProcesstype(Config.getInstance().get("b2b.processtype"));
        peticion.setSearchpattern("*");
        
        String salida = buscar(peticion);
        
        Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
        
        List<Filter> filtersAux = xml.getFilter();
        ArrayList<FilterBean> filters = new ArrayList<FilterBean>();
        for (Iterator<Filter> iterator = filtersAux.iterator(); iterator.hasNext();) {
            Filter next = iterator.next();
            if (next.getFilterkey() != null) {
                filters.add(new FilterBean(next));
            }
            
        }
        return filters;
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

    public List<ItemBean> buscarItems() {
        PeticionBean p = new PeticionBean();
        p.setUrl(Config.getInstance().get("b2b.url"));
        p.setLoginid(Config.getInstance().get("b2b.loginid"));
        p.setPassword(Config.getInstance().get("b2b.password"));
        p.setProcesstype(Config.getInstance().get("b2b.processtype"));
        p.setCategory(Config.getInstance().get("b2b.category"));
        p.setPagesize(Config.getInstance().get("b2b.pagesize"));
        p.setPage(Config.getInstance().get("b2b.page"));
        
        String salida = srv.buscar(p);
        
        Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
        List<Item> items = xml.getItem();
        
        List<ItemBean> lista = new ArrayList<ItemBean>();
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
            Item next = iterator.next();
            lista.add(new ItemBean(next));
        }
        return lista;
    
    }

    public List<ItemBean> marcarTodos(List<ItemBean> items, boolean value) {
        for (Iterator<ItemBean> iterator = items.iterator(); iterator.hasNext();) {
            ItemBean next = iterator.next();
            next.setCargar(value);
        }
        return items;
    }

}
