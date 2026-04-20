# CRUD de Audífonos

Sistema CRUD desarrollado en Java utilizando JPA (Hibernate) y PostgreSQL.

## 📌 Descripción
Este proyecto permite gestionar audífonos mediante operaciones básicas de base de datos:

- Crear (INSERT)
- Leer (SELECT)
- Actualizar (UPDATE)
- Eliminar (DELETE)

Se trabaja con dos tablas:
- tb_audifono
- tb_categoria

## 🧱 Tecnologías utilizadas
- Java
- JPA (Hibernate)
- PostgreSQL
- NetBeans

## 🗄️ Base de datos

La base de datos utilizada es **bd_audifonos**, con las siguientes tablas:

### tb_categoria
- id_cat (PK)
- descripcion_cat

### tb_audifono
- id_aud (PK)
- nombre_aud
- cantidad_aud
- precio_aud
- id_cat (FK)

## 🔗 Relación
Un audífono pertenece a una categoría (ManyToOne).

## ▶️ Ejecución
El proyecto se ejecuta desde la clase:
CrudAudifonos.java

## 📊 Ejemplo de datos
Se registraron audífonos como:
- Sony WH-1000XM5 (Bluetooth)
- HyperX Cloud II (Gamer)
- AirPods Pro (AirPods)
- JBL Sport (Deportivos)
- Logitech G435 (Con cable)

## 📷 Resultado
El sistema muestra los datos mediante consultas SQL con JOIN entre tablas.

## 👨‍💻 Autor
Alex Lupercio
