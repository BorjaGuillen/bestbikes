/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "ps_image_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsImageType.findAll", query = "SELECT p FROM PsImageType p"),
    @NamedQuery(name = "PsImageType.findByIdImageType", query = "SELECT p FROM PsImageType p WHERE p.idImageType = :idImageType"),
    @NamedQuery(name = "PsImageType.findByName", query = "SELECT p FROM PsImageType p WHERE p.name = :name"),
    @NamedQuery(name = "PsImageType.findByWidth", query = "SELECT p FROM PsImageType p WHERE p.width = :width"),
    @NamedQuery(name = "PsImageType.findByHeight", query = "SELECT p FROM PsImageType p WHERE p.height = :height"),
    @NamedQuery(name = "PsImageType.findByProducts", query = "SELECT p FROM PsImageType p WHERE p.products = :products"),
    @NamedQuery(name = "PsImageType.findByCategories", query = "SELECT p FROM PsImageType p WHERE p.categories = :categories"),
    @NamedQuery(name = "PsImageType.findByManufacturers", query = "SELECT p FROM PsImageType p WHERE p.manufacturers = :manufacturers"),
    @NamedQuery(name = "PsImageType.findBySuppliers", query = "SELECT p FROM PsImageType p WHERE p.suppliers = :suppliers"),
    @NamedQuery(name = "PsImageType.findByScenes", query = "SELECT p FROM PsImageType p WHERE p.scenes = :scenes"),
    @NamedQuery(name = "PsImageType.findByStores", query = "SELECT p FROM PsImageType p WHERE p.stores = :stores")})
public class PsImageType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_image_type")
    private Integer idImageType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "width")
    private int width;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private int height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "products")
    private boolean products;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categories")
    private boolean categories;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manufacturers")
    private boolean manufacturers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suppliers")
    private boolean suppliers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scenes")
    private boolean scenes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stores")
    private boolean stores;

    public PsImageType() {
    }

    public PsImageType(Integer idImageType) {
        this.idImageType = idImageType;
    }

    public PsImageType(Integer idImageType, String name, int width, int height, boolean products, boolean categories, boolean manufacturers, boolean suppliers, boolean scenes, boolean stores) {
        this.idImageType = idImageType;
        this.name = name;
        this.width = width;
        this.height = height;
        this.products = products;
        this.categories = categories;
        this.manufacturers = manufacturers;
        this.suppliers = suppliers;
        this.scenes = scenes;
        this.stores = stores;
    }

    public Integer getIdImageType() {
        return idImageType;
    }

    public void setIdImageType(Integer idImageType) {
        this.idImageType = idImageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getProducts() {
        return products;
    }

    public void setProducts(boolean products) {
        this.products = products;
    }

    public boolean getCategories() {
        return categories;
    }

    public void setCategories(boolean categories) {
        this.categories = categories;
    }

    public boolean getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(boolean manufacturers) {
        this.manufacturers = manufacturers;
    }

    public boolean getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(boolean suppliers) {
        this.suppliers = suppliers;
    }

    public boolean getScenes() {
        return scenes;
    }

    public void setScenes(boolean scenes) {
        this.scenes = scenes;
    }

    public boolean getStores() {
        return stores;
    }

    public void setStores(boolean stores) {
        this.stores = stores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImageType != null ? idImageType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImageType)) {
            return false;
        }
        PsImageType other = (PsImageType) object;
        if ((this.idImageType == null && other.idImageType != null) || (this.idImageType != null && !this.idImageType.equals(other.idImageType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsImageType[ idImageType=" + idImageType + " ]";
    }
    
}
