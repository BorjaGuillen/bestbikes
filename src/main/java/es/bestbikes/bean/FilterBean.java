/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.bean;

import es.bestbikes.jaxb.Filter;

/**
 *
 * @author jorge
 */
public class FilterBean extends Filter{

    public FilterBean(Filter filter) {
        this.filtercount = filter.getFiltercount();
        this.filterdesc = filter.getFilterdesc();
        this.filterkey = filter.getFilterkey();
    }

    @Override
    public int hashCode() {
        if (this.filterkey == null) {
            return 0;
        }
        return this.filterkey.hashCode(); 
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;     
        }
        if (!(object instanceof FilterBean)) {
            return false;
        }
        FilterBean other = (FilterBean) object;
        if (this.filterkey == null) {
            return false;
        }
        if (other.getFilterkey() == null) {
            return false;
        }
        if (!this.filterkey.equals(other.getFilterdesc())) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
