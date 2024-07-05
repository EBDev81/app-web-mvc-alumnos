# App Web Alumnos

Esto es una práctica para el módulo Spring Boot desde cero del Bootcamp Cero de Keepcoding.

App Web Alumnos es una aplicación web desarrollada con Spring Boot para la gestión de alumnos y usuarios. 
Proporciona funcionalidades como crear, listar y actualizar alumnos y crear usuarios, así como autenticación de usuarios.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- MySQL 5.7 o superior

## Instalación

### Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/app-web-alumnos.git
cd app-web-alumnos
```

### Configurar la base de datos

Crea una base de datos MySQL.

```sql
CREATE DATABASE bd_web_spring_alumnos;
```

Configura las credenciales de la base de datos en `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/app_web_alumnos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Construir el proyecto

```bash
mvn clean install
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

## Estructura del Proyecto

- **src/main/java/io/keepcoding/app/web/alumnos**: Contiene el código fuente principal del proyecto.
  - **controller**: Controladores para manejar las solicitudes HTTP.
  - **entity**: Entidades JPA que representan las tablas de la base de datos.
  - **repository**: Repositorios JPA para interactuar con la base de datos.
  - **service**: Servicios que contienen la lógica de negocio.
  - **serviceimpl**: Implementaciones de los servicios.
- **src/main/resources**: Contiene los archivos de recursos.
  - **static**: Archivos estáticos como CSS y JavaScript.
  - **templates**: Plantillas Thymeleaf.
  - **application.properties**: Archivo de configuración de la aplicación.

## Uso

### Crear Usuario

1. Navega a `http://localhost:8080/usuarios/crear_usuario`.
2. Completa el formulario y haz clic en "Guardar".

### Listar Usuarios

1. Navega a `http://localhost:8080/usuarios`.
2. Se mostrará una lista de todos los usuarios registrados.

### Crear Alumno

1. Navega a `http://localhost:8080/alumnos/crear_alumno`.
2. Completa el formulario y haz clic en "Guardar".

### Listar Alumnos

1. Navega a `http://localhost:8080/alumnos`.
2. Se mostrará una lista de todos los alumnos registrados.

### Login de Usuario

1. Navega a `http://localhost:8080/login`.
2. Ingresa tu nombre de usuario y contraseña, y haz clic en "Acceder".

## Importación de Datos

Si deseas importar datos iniciales en la base de datos, puedes usar el archivo `import.sql` en `src/main/resources`.

```sql
INSERT INTO usuario (nombre, email, username, pass, activo) VALUES ('admin', 'admin@example.com', 'admin', 'admin', true);
```



