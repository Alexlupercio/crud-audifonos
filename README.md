# CRUD de Audífonos

Sistema CRUD desarrollado en Java utilizando JPA (Hibernate), JPQL y PostgreSQL.

## 📌 Descripción

Este proyecto permite gestionar audífonos mediante operaciones básicas de base de datos y consultas JPQL.  
Fue desarrollado como parte de la asignatura Persistencia de Datos, aplicando un modelo ORM con entidades JPA, relaciones entre clases y consultas orientadas a objetos.

## 🧱 Tecnologías utilizadas

- Java
- Maven
- JPA
- Hibernate
- JPQL
- PostgreSQL
- NetBeans

## 🗄️ Base de datos

La base de datos utilizada es:

```text
bd_audifonos
```

El modelo trabaja con las siguientes tablas:

- `tb_audifono`
- `tb_categoria`
- `tb_proveedor`
- `tb_cliente`
- `tb_mantenimiento`

## 🧩 Entidades JPA

Las tablas fueron representadas mediante entidades Java:

- `TbAudifono`
- `TbCategoria`
- `TbProveedor`
- `TbCliente`
- `TbMantenimiento`

## 🔗 Relaciones implementadas

El modelo ORM incluye las siguientes relaciones:

- Una categoría puede tener varios audífonos.
- Un proveedor puede suministrar varios audífonos.
- Un audífono puede tener varios registros de mantenimiento.
- Un cliente puede solicitar varios mantenimientos.

En el código se utilizan anotaciones como:

- `@Entity`
- `@Table`
- `@ManyToOne`
- `@OneToMany`
- `@JoinColumn`

## 🔎 Consultas JPQL implementadas

Se implementaron consultas JPQL para obtener información relevante del sistema:

1. Listar audífonos disponibles ordenados por precio.
2. Buscar audífonos por categoría.
3. Listar mantenimientos pendientes.
4. Listar proveedores con audífonos asociados.

Las consultas incluyen filtros, ordenamiento y paginación mediante:

```java
query.setFirstResult(inicio);
query.setMaxResults(limite);
```

## ⚙️ Configuración de persistencia

La conexión con PostgreSQL se configura en el archivo:

```text
src/main/resources/META-INF/persistence.xml
```

En este archivo se registra la unidad de persistencia `AudifonosPU`, las entidades JPA del modelo ORM y los parámetros de conexión a la base de datos.

## ▶️ Ejecución

El proyecto se ejecuta desde la clase principal:

```text
CrudAudifonos.java
```

Las consultas JPQL se encuentran implementadas en:

```text
ConsultasJPQL.java
```

## 📊 Ejemplo de datos

Se registraron audífonos como:

- Sony WH-1000XM5
- HyperX Cloud II
- AirPods Pro
- JBL Sport
- Logitech G435

También se registraron categorías, proveedores, clientes y mantenimientos para probar las relaciones y consultas JPQL.

## 📷 Resultado

El sistema muestra en consola los resultados de las consultas JPQL, evidenciando la conexión con PostgreSQL y el funcionamiento del modelo ORM.

## 👨‍💻 Autor

Alex Lupercio
