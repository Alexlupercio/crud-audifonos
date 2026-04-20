/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudaudifonos.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "tb_audifono")
@NamedQueries({
    @NamedQuery(name = "TbAudifono.findAll", query = "SELECT t FROM TbAudifono t"),
    @NamedQuery(name = "TbAudifono.findByIdAud", query = "SELECT t FROM TbAudifono t WHERE t.idAud = :idAud"),
    @NamedQuery(name = "TbAudifono.findByNombreAud", query = "SELECT t FROM TbAudifono t WHERE t.nombreAud = :nombreAud"),
    @NamedQuery(name = "TbAudifono.findByCantidadAud", query = "SELECT t FROM TbAudifono t WHERE t.cantidadAud = :cantidadAud"),
    @NamedQuery(name = "TbAudifono.findByPrecioAud", query = "SELECT t FROM TbAudifono t WHERE t.precioAud = :precioAud")})
public class TbAudifono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aud")
    private Integer idAud;
    @Basic(optional = false)
    @Column(name = "nombre_aud")
    private String nombreAud;
    @Basic(optional = false)
    @Column(name = "cantidad_aud")
    private int cantidadAud;
    @Basic(optional = false)
    @Column(name = "precio_aud")
    private double precioAud;
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    @ManyToOne(optional = false)
    private TbCategoria idCat;

    public TbAudifono() {
    }

    public TbAudifono(Integer idAud) {
        this.idAud = idAud;
    }

    public TbAudifono(Integer idAud, String nombreAud, int cantidadAud, double precioAud) {
        this.idAud = idAud;
        this.nombreAud = nombreAud;
        this.cantidadAud = cantidadAud;
        this.precioAud = precioAud;
    }

    public Integer getIdAud() {
        return idAud;
    }

    public void setIdAud(Integer idAud) {
        this.idAud = idAud;
    }

    public String getNombreAud() {
        return nombreAud;
    }

    public void setNombreAud(String nombreAud) {
        this.nombreAud = nombreAud;
    }

    public int getCantidadAud() {
        return cantidadAud;
    }

    public void setCantidadAud(int cantidadAud) {
        this.cantidadAud = cantidadAud;
    }

    public double getPrecioAud() {
        return precioAud;
    }

    public void setPrecioAud(double precioAud) {
        this.precioAud = precioAud;
    }

    public TbCategoria getIdCat() {
        return idCat;
    }

    public void setIdCat(TbCategoria idCat) {
        this.idCat = idCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAud != null ? idAud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAudifono)) {
            return false;
        }
        TbAudifono other = (TbAudifono) object;
        if ((this.idAud == null && other.idAud != null) || (this.idAud != null && !this.idAud.equals(other.idAud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.crudaudifonos.entities.TbAudifono[ idAud=" + idAud + " ]";
    }
    
}
