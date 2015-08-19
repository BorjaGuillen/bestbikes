/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.control.bbdd;

import es.bestbikes.bean.ItemBean;
import es.bestbikes.exception.ControlBbddException;
import es.bestbikes.util.Trazas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author isthar
 */
public class ControlBBDD {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("es.bestbikes.persistence");
    
    private static EntityManager em;
    
    public static EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            emf.getCache().evictAll();
            em = emf.createEntityManager();
        } 
        return em;
    
    }
    
}
