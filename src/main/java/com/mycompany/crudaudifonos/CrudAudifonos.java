package com.mycompany.crudaudifonos;

import com.mycompany.crudaudifonos.entities.TbAudifono;
import com.mycompany.crudaudifonos.entities.TbCategoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CrudAudifonos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AudifonosPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            TbCategoria categoria = em.find(TbCategoria.class, 6);

            TbAudifono audifono = new TbAudifono();
            audifono.setNombreAud("Logitech G435");
            audifono.setCantidadAud(7);
            audifono.setPrecioAud(95.0);
            audifono.setIdCat(categoria);

            em.persist(audifono);

            em.getTransaction().commit();

            System.out.println("Audifono guardado correctamente");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al insertar");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}