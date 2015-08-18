
import es.bestbikes.bean.FilterBean;
import es.bestbikes.jaxb.Filter;
import es.bestbikes.mb.ControlMB;
import es.bestbikes.servicios.PeticionSrv;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
@FacesConverter("filterConverter")
public class FilterConverter implements Converter{
    
    private List<FilterBean> filters;

    public FilterConverter() {
        PeticionSrv srv = PeticionSrv.getInstance();
        filters = srv.buscarCategorias(); 
    }
    
    
    
     public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            Filter salida = null;
            for (Iterator iterator = filters.iterator(); iterator.hasNext();) {
                Filter next = (Filter) iterator.next();
                if (value.equals(next.getFilterkey())) {
                    salida = next;
                }
            }
            return salida;
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null && !"".equals(object)) {
            return String.valueOf(((Filter) object).getFilterkey());
        }
        else {
            return null;
        }
    }   
    
}
