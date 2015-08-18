/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author isthar
 */
@Embeddable
public class PsImageLangPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_image")
    private int idImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lang")
    private int idLang;

    public PsImageLangPK() {
    }

    public PsImageLangPK(int idImage, int idLang) {
        this.idImage = idImage;
        this.idLang = idLang;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idImage;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImageLangPK)) {
            return false;
        }
        PsImageLangPK other = (PsImageLangPK) object;
        if (this.idImage != other.idImage) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsImageLangPK[ idImage=" + idImage + ", idLang=" + idLang + " ]";
    }
    
}
