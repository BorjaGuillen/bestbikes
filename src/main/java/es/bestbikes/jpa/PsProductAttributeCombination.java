/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_product_attribute_combination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttributeCombination.findAll", query = "SELECT p FROM PsProductAttributeCombination p"),
    @NamedQuery(name = "PsProductAttributeCombination.findByIdAttribute", query = "SELECT p FROM PsProductAttributeCombination p WHERE p.psProductAttributeCombinationPK.idAttribute = :idAttribute"),
    @NamedQuery(name = "PsProductAttributeCombination.findByIdProductAttribute", query = "SELECT p FROM PsProductAttributeCombination p WHERE p.psProductAttributeCombinationPK.idProductAttribute = :idProductAttribute")})
public class PsProductAttributeCombination implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductAttributeCombinationPK psProductAttributeCombinationPK;

    public PsProductAttributeCombination() {
    }

    public PsProductAttributeCombination(PsProductAttributeCombinationPK psProductAttributeCombinationPK) {
        this.psProductAttributeCombinationPK = psProductAttributeCombinationPK;
    }

    public PsProductAttributeCombination(int idAttribute, int idProductAttribute) {
        this.psProductAttributeCombinationPK = new PsProductAttributeCombinationPK(idAttribute, idProductAttribute);
    }

    public PsProductAttributeCombinationPK getPsProductAttributeCombinationPK() {
        return psProductAttributeCombinationPK;
    }

    public void setPsProductAttributeCombinationPK(PsProductAttributeCombinationPK psProductAttributeCombinationPK) {
        this.psProductAttributeCombinationPK = psProductAttributeCombinationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductAttributeCombinationPK != null ? psProductAttributeCombinationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeCombination)) {
            return false;
        }
        PsProductAttributeCombination other = (PsProductAttributeCombination) object;
        if ((this.psProductAttributeCombinationPK == null && other.psProductAttributeCombinationPK != null) || (this.psProductAttributeCombinationPK != null && !this.psProductAttributeCombinationPK.equals(other.psProductAttributeCombinationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttributeCombination[ psProductAttributeCombinationPK=" + psProductAttributeCombinationPK + " ]";
    }
    
}
