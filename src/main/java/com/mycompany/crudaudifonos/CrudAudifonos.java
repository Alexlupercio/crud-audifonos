package com.mycompany.crudaudifonos;

import com.mycompany.crudaudifonos.entities.TbAudifono;
import com.mycompany.crudaudifonos.entities.TbMantenimiento;
import com.mycompany.crudaudifonos.entities.TbProveedor;
import java.util.List;

public class CrudAudifonos {

    public static void main(String[] args) {

        ConsultasJPQL consultas = new ConsultasJPQL();

        try {
            /*
             * Consulta 1:
             * Lista los audífonos con stock disponible,
             * ordenados por precio de menor a mayor.
             */
            System.out.println("=== CONSULTA 1: AUDIFONOS DISPONIBLES ===");
            List<TbAudifono> audifonosDisponibles = consultas.listarAudifonosDisponibles(0, 10);

            for (TbAudifono audifono : audifonosDisponibles) {
                System.out.println(
                        "ID: " + audifono.getIdAud()
                        + " | Nombre: " + audifono.getNombreAud()
                        + " | Cantidad: " + audifono.getCantidadAud()
                        + " | Precio: " + audifono.getPrecioAud()
                );
            }

            /*
             * Consulta 2:
             * Busca audífonos por una categoría existente en la base de datos.
             * En este caso se usa la categoría "Gamer".
             */
            System.out.println("\n=== CONSULTA 2: AUDIFONOS POR CATEGORIA ===");
            List<TbAudifono> audifonosPorCategoria = consultas.buscarAudifonosPorCategoria("Gamer", 0, 10);

            for (TbAudifono audifono : audifonosPorCategoria) {
                System.out.println(
                        "ID: " + audifono.getIdAud()
                        + " | Nombre: " + audifono.getNombreAud()
                        + " | Categoria: " + audifono.getIdCat().getDescripcionCat()
                );
            }

            /*
             * Consulta 3:
             * Lista los mantenimientos pendientes registrados en el sistema.
             */
            System.out.println("\n=== CONSULTA 3: MANTENIMIENTOS PENDIENTES ===");
            List<TbMantenimiento> mantenimientos = consultas.listarMantenimientosPorEstado("Pendiente", 0, 10);

            for (TbMantenimiento mantenimiento : mantenimientos) {
                System.out.println(
                        "ID: " + mantenimiento.getIdMan()
                        + " | Estado: " + mantenimiento.getEstadoMan()
                        + " | Descripcion: " + mantenimiento.getDescripcionMan()
                        + " | Costo: " + mantenimiento.getCostoMan()
                );
            }

            /*
             * Consulta 4:
             * Muestra los proveedores que tienen audífonos asociados.
             */
            System.out.println("\n=== CONSULTA 4: PROVEEDORES CON AUDIFONOS ===");
            List<TbProveedor> proveedores = consultas.listarProveedoresConAudifonos(0, 10);

            for (TbProveedor proveedor : proveedores) {
                System.out.println(
                        "ID: " + proveedor.getIdPro()
                        + " | Nombre: " + proveedor.getNombrePro()
                        + " | Correo: " + proveedor.getCorreoPro()
                );
            }

        } finally {
            consultas.cerrar();
        }
    }
}