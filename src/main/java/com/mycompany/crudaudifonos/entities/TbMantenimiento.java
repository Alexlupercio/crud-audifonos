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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_mantenimiento")
@NamedQueries({
    @NamedQuery(name = "TbMantenimiento.findAll", query = "SELECT t FROM TbMantenimiento t"),
    @NamedQuery(name = "TbMantenimiento.findByIdMan", query = "SELECT t FROM TbMantenimiento t WHERE t.idMan = :idMan"),
    @NamedQuery(name = "TbMantenimiento.findByEstadoMan", query = "SELECT t FROM TbMantenimiento t WHERE t.estadoMan = :estadoMan")
})
public class TbMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_man")
    private Integer idMan;

    @Basic(optional = false)
    @Column(name = "fecha_man")
    @Temporal(TemporalType.DATE)
    private Date fechaMan;

    @Basic(optional = false)
    @Column(name = "descripcion_man")
    private String descripcionMan;

    @Basic(optional = false)
    @Column(name = "costo_man")
    private double costoMan;

    @Basic(optional = false)
    @Column(name = "estado_man")
    private String estadoMan;

    // Relación muchos a uno:
    // Muchos mantenimientos pueden pertenecer a un cliente.
    @JoinColumn(name = "id_cli", referencedColumnName = "id_cli")
    @ManyToOne(optional = false)
    private TbCliente idCli;

    // Relación muchos a uno:
    // Muchos mantenimientos pueden pertenecer a un audífono.
    @JoinColumn(name = "id_aud", referencedColumnName = "id_aud")
    @ManyToOne(optional = false)
    private TbAudifono idAud;

    public TbMantenimiento() {
    }

    public TbMantenimiento(Integer idMan) {
        this.idMan = idMan;
    }

    public TbMantenimiento(Integer idMan, Date fechaMan, String descripcionMan, double costoMan, String estadoMan) {
        this.idMan = idMan;
        this.fechaMan = fechaMan;
        this.descripcionMan = descripcionMan;
        this.costoMan = costoMan;
        this.estadoMan = estadoMan;
    }

    public Integer getIdMan() {
        return idMan;
    }

    public void setIdMan(Integer idMan) {
        this.idMan = idMan;
    }

    public Date getFechaMan() {
        return fechaMan;
    }

    public void setFechaMan(Date fechaMan) {
        this.fechaMan = fechaMan;
    }

    public String getDescripcionMan() {
        return descripcionMan;
    }

    public void setDescripcionMan(String descripcionMan) {
        this.descripcionMan = descripcionMan;
    }

    public double getCostoMan() {
        return costoMan;
    }

    public void setCostoMan(double costoMan) {
        this.costoMan = costoMan;
    }

    public String getEstadoMan() {
        return estadoMan;
    }

    public void setEstadoMan(String estadoMan) {
        this.estadoMan = estadoMan;
    }

    public TbCliente getIdCli() {
        return idCli;
    }

    public void setIdCli(TbCliente idCli) {
        this.idCli = idCli;
    }

    public TbAudifono getIdAud() {
        return idAud;
    }

    public void setIdAud(TbAudifono idAud) {
        this.idAud = idAud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMan != null ? idMan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbMantenimiento)) {
            return false;
        }

        TbMantenimiento other = (TbMantenimiento) object;

        if ((this.idMan == null && other.idMan != null) ||
            (this.idMan != null && !this.idMan.equals(other.idMan))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Mantenimiento: " + estadoMan + " - " + descripcionMan;
    }
}