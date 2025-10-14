# 🧾 Invoicing App - Spring Boot

Aplicación de facturación desarrollada con **Java + Spring Boot**, **MySQL**, y **Docker**, diseñada para gestionar clientes, facturas y productos de forma eficiente.  
Este proyecto fue creado con el objetivo de aprender y aplicar buenas prácticas en el desarrollo backend, arquitectura en capas y uso de DTOs.

---

## 🚀 Tecnologías utilizadas

| Categoría | Tecnologías |
|------------|--------------|
| **Backend** | Java 17, Spring Boot (Web, Data JPA, Validation, Lombok) |
| **Base de datos** | MySQL 8 (contenedor Docker) |
| **Seguridad (planificada)** | JWT Authentication |
| **Contenerización** | Docker & Docker Compose |
| **ORM** | Hibernate / JPA |
| **Dependencias adicionales** | Lombok, ModelMapper, Spring DevTools |
| **IDE'** | IntelliJ IDEA  |

---

## 🧠 Conceptos aplicados

- Arquitectura en capas: **Controller → Service → Repository → Entity**
- Uso de **DTOs (Data Transfer Objects)** para aislar la lógica de negocio del modelo de persistencia
- Configuración de **Docker Compose** para levantar MySQL y la aplicación
- Relación de entidades:  
  - `Invoice` → `@OneToMany` con `Item`  
  - `Invoice` → `@ManyToOne` con `Client` y `User`
- Manejo de excepciones y validaciones con `@Valid`
- Uso de **Spring Data JPA** para operaciones CRUD

---

## 🧩 Estructura del proyecto

```bash
src/
├── main/
│   ├── java/com/example/invoicing/
│   │   ├── controller/      # Controladores REST
│   │   ├── dto/             # Clases DTO
│   │   ├── entity/          # Entidades JPA
│   │   ├── repository/      # Interfaces Repository
│   │   ├── service/         # Lógica de negocio
│   │   └── InvoicingApplication.java
│   └── resources/
│       ├── application.yml
│       └── data.sql (opcional)
├── test/                    # Tests unitarios (por implementar)
├── docker-compose.yml
└── README.md


| Método   | Endpoint             | Descripción                |
| -------- | -------------------- | -------------------------- |
| `GET`    | `/api/invoices`      | Obtener todas las facturas |
| `POST`   | `/api/invoices`      | Crear una nueva factura    |
| `GET`    | `/api/invoices/{id}` | Obtener factura por ID     |
| `DELETE` | `/api/invoices/{id}` | Eliminar factura           |


💡 Próximas mejoras

Autenticación con JWT

Pruebas unitarias con JUnit y Mockito

Interfaz frontend sencilla (React o Angular)

Documentación con Swagger
