package com.mycompany.crudaudifonos.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_audifono")
@NamedQueries({
    @NamedQuery(name = "TbAudifono.findAll", query = "SELECT t FROM TbAudifono t"),
    @NamedQuery(name = "TbAudifono.findByIdAud", query = "SELECT t FROM TbAudifono t WHERE t.idAud = :idAud"),
    @NamedQuery(name = "TbAudifono.findByNombreAud", query = "SELECT t FROM TbAudifono t WHERE t.nombreAud = :nombreAud"),
    @NamedQuery(name = "TbAudifono.findByCantidadAud", query = "SELECT t FROM TbAudifono t WHERE t.cantidadAud = :cantidadAud"),
    @NamedQuery(name = "TbAudifono.findByPrecioAud", query = "SELECT t FROM TbAudifono t WHERE t.precioAud = :precioAud")
})
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

    // Relación muchos a uno:
    // Varios audífonos pueden estar asociados a una misma categoría.
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    @ManyToOne(optional = false)
    private TbCategoria idCat;

    // Relación muchos a uno:
    // Varios audífonos pueden ser suministrados por un mismo proveedor.
    @JoinColumn(name = "id_pro", referencedColumnName = "id_pro")
    @ManyToOne(optional = true)
    private TbProveedor idPro;

    // Relación uno a varios:
    // Un audífono puede tener diferentes registros de mantenimiento.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAud")
    private Collection<TbMantenimiento> tbMantenimientoCollection;

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

    public TbProveedor getIdPro() {
        return idPro;
    }

    public void setIdPro(TbProveedor idPro) {
        this.idPro = idPro;
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
        hash += (idAud != null ? idAud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbAudifono)) {
            return false;
        }

        TbAudifono other = (TbAudifono) object;

        if ((this.idAud == null && other.idAud != null)
                || (this.idAud != null && !this.idAud.equals(other.idAud))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Audifono: " + nombreAud;
    }
}