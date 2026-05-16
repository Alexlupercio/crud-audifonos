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
@Table(name = "tb_proveedor")
@NamedQueries({
    @NamedQuery(name = "TbProveedor.findAll", query = "SELECT t FROM TbProveedor t"),
    @NamedQuery(name = "TbProveedor.findByIdPro", query = "SELECT t FROM TbProveedor t WHERE t.idPro = :idPro"),
    @NamedQuery(name = "TbProveedor.findByNombrePro", query = "SELECT t FROM TbProveedor t WHERE t.nombrePro = :nombrePro")
})
public class TbProveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pro")
    private Integer idPro;

    @Basic(optional = false)
    @Column(name = "nombre_pro")
    private String nombrePro;

    @Basic(optional = false)
    @Column(name = "telefono_pro")
    private String telefonoPro;

    @Basic(optional = false)
    @Column(name = "correo_pro")
    private String correoPro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPro")
    private Collection<TbAudifono> tbAudifonoCollection;

    public TbProveedor() {
    }

    public TbProveedor(Integer idPro) {
        this.idPro = idPro;
    }

    public TbProveedor(Integer idPro, String nombrePro, String telefonoPro, String correoPro) {
        this.idPro = idPro;
        this.nombrePro = nombrePro;
        this.telefonoPro = telefonoPro;
        this.correoPro = correoPro;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getTelefonoPro() {
        return telefonoPro;
    }

    public void setTelefonoPro(String telefonoPro) {
        this.telefonoPro = telefonoPro;
    }

    public String getCorreoPro() {
        return correoPro;
    }

    public void setCorreoPro(String correoPro) {
        this.correoPro = correoPro;
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
        hash += (idPro != null ? idPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbProveedor)) {
            return false;
        }
        TbProveedor other = (TbProveedor) object;
        if ((this.idPro == null && other.idPro != null) || (this.idPro != null && !this.idPro.equals(other.idPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor: " + nombrePro;
    }
}