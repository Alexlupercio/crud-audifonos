package com.mycompany.crudaudifonos;

import com.mycompany.crudaudifonos.entities.TbAudifono;
import com.mycompany.crudaudifonos.entities.TbMantenimiento;
import com.mycompany.crudaudifonos.entities.TbProveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ConsultasJPQL {

    private final EntityManagerFactory emf;

    public ConsultasJPQL() {
        this.emf = Persistence.createEntityManagerFactory("AudifonosPU");
    }

    /*
     * Consulta 1:
     * Obtiene audífonos disponibles, aplicando filtro por cantidad,
     * ordenamiento por precio y paginación.
     */
    public List<TbAudifono> listarAudifonosDisponibles(int inicio, int limite) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<TbAudifono> query = em.createQuery(
                    "SELECT a FROM TbAudifono a "
                    + "WHERE a.cantidadAud > 0 "
                    + "ORDER BY a.precioAud ASC",
                    TbAudifono.class
            );

            query.setFirstResult(inicio);
            query.setMaxResults(limite);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /*
     * Consulta 2:
     * Busca audífonos por categoría, ordenados alfabéticamente.
     * Se usa la relación entre TbAudifono y TbCategoria.
     */
    public List<TbAudifono> buscarAudifonosPorCategoria(String categoria, int inicio, int limite) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<TbAudifono> query = em.createQuery(
                    "SELECT a FROM TbAudifono a "
                    + "WHERE LOWER(a.idCat.descripcionCat) LIKE LOWER(:categoria) "
                    + "ORDER BY a.nombreAud ASC",
                    TbAudifono.class
            );

            query.setParameter("categoria", "%" + categoria + "%");
            query.setFirstResult(inicio);
            query.setMaxResults(limite);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /*
     * Consulta 3:
     * Lista mantenimientos según su estado, ordenados por fecha.
     * Se usa la entidad TbMantenimiento relacionada con cliente y audífono.
     */
    public List<TbMantenimiento> listarMantenimientosPorEstado(String estado, int inicio, int limite) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<TbMantenimiento> query = em.createQuery(
                    "SELECT m FROM TbMantenimiento m "
                    + "WHERE LOWER(m.estadoMan) = LOWER(:estado) "
                    + "ORDER BY m.fechaMan DESC",
                    TbMantenimiento.class
            );

            query.setParameter("estado", estado);
            query.setFirstResult(inicio);
            query.setMaxResults(limite);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /*
     * Consulta adicional:
     * Lista proveedores que tienen audífonos registrados.
     * Sirve para evidenciar la relación proveedor-audífono.
     */
    public List<TbProveedor> listarProveedoresConAudifonos(int inicio, int limite) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<TbProveedor> query = em.createQuery(
                    "SELECT DISTINCT p FROM TbProveedor p "
                    + "JOIN p.tbAudifonoCollection a "
                    + "ORDER BY p.nombrePro ASC",
                    TbProveedor.class
            );

            query.setFirstResult(inicio);
            query.setMaxResults(limite);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}