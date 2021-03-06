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
import es.bestbikes.types.TypeAtributos;
import es.bestbikes.types.TypeJaxb;
import es.bestbikes.util.Config;
import es.bestbikes.util.JaxbUtil;
import es.bestbikes.util.Trazas;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;

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
            if (peticion.getAtributo()!= null) {
                urlstring += "&searchpattern=" + peticion.getAtributo();            
            }

            urlstring += "&noek=0&ouvp=0&noavail=0";
            Trazas.trazar(urlstring);
            
            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Content-Type","text/xml; charset=ISO-8859-1");
            //conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Accept-Charset", "ISO-8859-1");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "ISO-8859-1"));
            //BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
            String output;
            salida = "";
            while ((output = br.readLine()) != null) {
                salida += output;
                //System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return salida;
    }


    
    public List<ItemBean> buscarItems(String categoria, long nmitems) {
        List<ItemBean> lista = new ArrayList<ItemBean>();
        
        int nmpagina = 1;
        while (lista.size() < nmitems) {
            PeticionBean p = new PeticionBean();
            p.setUrl(Config.getInstance().get("b2b.url"));
            p.setLoginid(Config.getInstance().get("b2b.loginid"));
            p.setPassword(Config.getInstance().get("b2b.password"));
            p.setProcesstype(Config.getInstance().get("b2b.processtype"));
            //p.setCategory(Config.getInstance().get("b2b.category"));
            p.setCategory(categoria);
            p.setPagesize(Config.getInstance().get("b2b.pagesize"));
            p.setPage(nmpagina + "");

            String salida = srv.buscar(p);

            Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
            List<Item> items = xml.getItem();


            for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
                Item next = iterator.next();
                lista.add(new ItemBean(next));
            }
            nmpagina++;
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

    public  List<ItemBean> obtenerTodosLosItems() {
        List<ItemBean> lista = new ArrayList<ItemBean>();
        
        int nmpagina = 1;
        int nmpaginas = nmpagina + 1;

        while (nmpagina <= nmpaginas) {
            PeticionBean p = new PeticionBean();
            p.setUrl(Config.getInstance().get("b2b.url"));
            p.setLoginid(Config.getInstance().get("b2b.loginid"));
            p.setPassword(Config.getInstance().get("b2b.password"));
            p.setProcesstype(Config.getInstance().get("b2b.processtype"));
            //p.setCategory(Config.getInstance().get("b2b.category"));
            //p.setCategory(categoria);
            p.setPagesize(Config.getInstance().get("b2b.pagesize"));
            p.setPage(nmpagina + "");

            String salida = srv.buscar(p);

            Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
            if (xml != null) {
                nmpaginas = xml.getOfpages().intValue();
                List<Item> items = xml.getItem();


                for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
                    Item next = iterator.next();
                    lista.add(new ItemBean(next));
                }
                nmpagina++;
            }
        }
        return lista;    
    }

    
    public int obtenerTodosLosItemsNumpag() {
        int nmpaginas = 0;
        Root xml = null;

        while (xml == null) {
            PeticionBean p = new PeticionBean();
            p.setUrl(Config.getInstance().get("b2b.url"));
            p.setLoginid(Config.getInstance().get("b2b.loginid"));
            p.setPassword(Config.getInstance().get("b2b.password"));
            p.setProcesstype(Config.getInstance().get("b2b.processtype"));
            p.setPagesize(Config.getInstance().get("b2b.pagesize"));
            p.setPage("1");

            String salida = srv.buscar(p);

            xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
            if (xml != null) {
                nmpaginas = xml.getOfpages().intValue();
            }
        }
        return nmpaginas;    
    }
    
    public  List<ItemBean> obtenerTodosLosItems(int nmpagina) {
        List<ItemBean> lista = new ArrayList<ItemBean>();
        
        Root xml = null;

        while (xml == null) {
            PeticionBean p = new PeticionBean();
            p.setUrl(Config.getInstance().get("b2b.url"));
            p.setLoginid(Config.getInstance().get("b2b.loginid"));
            p.setPassword(Config.getInstance().get("b2b.password"));
            p.setProcesstype(Config.getInstance().get("b2b.processtype"));
            //p.setCategory(Config.getInstance().get("b2b.category"));
            //p.setCategory(categoria);
            p.setPagesize(Config.getInstance().get("b2b.pagesize"));
            p.setPage(nmpagina + "");

            String salida = srv.buscar(p);

            xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
            if (xml != null) {
                List<Item> items = xml.getItem();
                for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
                    Item next = iterator.next();
                    lista.add(new ItemBean(next));
                }
            }
        }
        return lista;    
    }

    public BufferedImage obtenerImagen(String ruta) {
        BufferedImage salida = null;
        try {
            URL url = new URL(ruta);
            salida = ImageIO.read(url);
        } catch(Exception e) {
            Trazas.trazarWarning(e.getMessage());
        }
        return salida;
    }
    
    public String obtenerDatosURL(String ruta) {
        
        if (ruta==null) return null;
        String salida = null;
        try {            
            URL url = new URL(ruta);        
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept-Charset", "ISO-8859-1");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "ISO-8859-1"));
            //BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
            String output;
            salida = "";
            while ((output = br.readLine()) != null) {
                salida += output;
            }

            conn.disconnect();
           
        } catch(Exception e) {
            salida = null;
            String nombreClaseAfectada;
            nombreClaseAfectada = "("+this.getClass().getSimpleName()+"-obtenerDatosURL"+") ";
            Trazas.trazarWarning(nombreClaseAfectada+e.getMessage());
        }
        
        if (salida != null) {
            int index = salida.toUpperCase().indexOf("<BODY");
            if (index >= 0) {
                while(salida.charAt(index) != '>') {
                    index++;
                }
                String tempo = salida.substring(index+1);
                salida = tempo.split("</BODY>")[0];
            }
        }
        
        
       /*
        String[] auxS = salida.split("<BODY scroll=auto>");
        if (auxS.length>1) {
            salida = auxS[1];
            auxS = salida.split("</BODY>");
            salida = auxS[0];
        }
        */
        return salida;
    }


    public List<ItemBean> obtenerItemsPorAtributo(TypeAtributos objTA) {
        List<ItemBean> lista = new ArrayList<ItemBean>();
        
        int nmpagina = 1;
        int nmpaginas = nmpagina + 1;

        while (nmpagina <= nmpaginas) {
            PeticionBean p = new PeticionBean();
            p.setUrl(Config.getInstance().get("b2b.url"));
            p.setLoginid(Config.getInstance().get("b2b.loginid"));
            p.setPassword(Config.getInstance().get("b2b.password"));
            p.setProcesstype(Config.getInstance().get("b2b.processtype"));
            //p.setCategory(Config.getInstance().get("b2b.category"));
            //p.setCategory(categoria);
            p.setPagesize(Config.getInstance().get("b2b.pagesize"));
            p.setPage(nmpagina + "");
            p.setCategory(objTA.getCodcategoria());
            p.setAtributo(objTA.getAtributo());

            String salida = srv.buscar(p);

            Root xml = (Root) JaxbUtil.unmarshall(salida, TypeJaxb.BEST_BIKES);
            if (xml != null) {
                nmpaginas = xml.getOfpages().intValue();
                List<Item> items = xml.getItem();


                for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
                    Item next = iterator.next();
                    lista.add(new ItemBean(next));
                }
                nmpagina++;
            }
        }
        return lista;    
    }


}
