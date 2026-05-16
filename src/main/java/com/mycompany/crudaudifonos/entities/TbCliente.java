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

@Entity
@Table(name = "tb_cliente")
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t"),
    @NamedQuery(name = "TbCliente.findByIdCli", query = "SELECT t FROM TbCliente t WHERE t.idCli = :idCli"),
    @NamedQuery(name = "TbCliente.findByNombreCli", query = "SELECT t FROM TbCliente t WHERE t.nombreCli = :nombreCli")
})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cli")
    private Integer idCli;

    @Basic(optional = false)
    @Column(name = "nombre_cli")
    private String nombreCli;

    @Basic(optional = false)
    @Column(name = "telefono_cli")
    private String telefonoCli;

    @Basic(optional = false)
    @Column(name = "correo_cli")
    private String correoCli;

    // Relación uno a varios:
    // Un cliente puede tener varios mantenimientos.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCli")
    private Collection<TbMantenimiento> tbMantenimientoCollection;

    public TbCliente() {
    }

    public TbCliente(Integer idCli) {
        this.idCli = idCli;
    }

    public TbCliente(Integer idCli, String nombreCli, String telefonoCli, String correoCli) {
        this.idCli = idCli;
        this.nombreCli = nombreCli;
        this.telefonoCli = telefonoCli;
        this.correoCli = correoCli;
    }

    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        this.idCli = idCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(String telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }

    public Collection<TbMantenimiento> getTbMantenimientoCollection() {
        return tbMantenimientoCollection;
    }

    public void setTbMantenimientoCollection(Collection<TbMantenimiento> tbMantenimientoCollection) {
        this.tbMantenimientoCollection = tbMantenimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCli != null ? idCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbCliente)) {
            return false;
        }

        TbCliente other = (TbCliente) object;

        if ((this.idCli == null && other.idCli != null) ||
            (this.idCli != null && !this.idCli.equals(other.idCli))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCli;
    }
}