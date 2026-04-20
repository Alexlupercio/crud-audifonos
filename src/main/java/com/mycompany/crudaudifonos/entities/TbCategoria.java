/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudaudifonos.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "tb_categoria")
@NamedQueries({
    @NamedQuery(name = "TbCategoria.findAll", query = "SELECT t FROM TbCategoria t"),
    @NamedQuery(name = "TbCategoria.findByIdCat", query = "SELECT t FROM TbCategoria t WHERE t.idCat = :idCat"),
    @NamedQuery(name = "TbCategoria.findByDescripcionCat", query = "SELECT t FROM TbCategoria t WHERE t.descripcionCat = :descripcionCat")})
public class TbCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cat")
    private Integer idCat;
    @Basic(optional = false)
    @Column(name = "descripcion_cat")
    private String descripcionCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCat")
    private Collection<TbAudifono> tbAudifonoCollection;

    public TbCategoria() {
    }

    public TbCategoria(Integer idCat) {
        this.idCat = idCat;
    }

    public TbCategoria(Integer idCat, String descripcionCat) {
        this.idCat = idCat;
        this.descripcionCat = descripcionCat;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }

    public Collection<TbAudifono> getTbAudifonoCollection() {
        return tbAudifonoCollection;
    }

    public void setTbAudifonoCollection(Collection<TbAudifono> tbAudifonoCollection) {
        this.tbAudifonoCollection = tbAudifonoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCat != null ? idCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategoria)) {
            return false;
        }
        TbCategoria other = (TbCategoria) object;
        if ((this.idCat == null && other.idCat != null) || (this.idCat != null && !this.idCat.equals(other.idCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crudaudifonos.entities.TbCategoria[ idCat=" + idCat + " ]";
    }
    
}
