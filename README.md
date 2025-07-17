
# Prueba Técnica – Desarrollador(a) Java Spring Boot

## Objetivo
Construir una API REST en Java con Spring Boot que permita a usuarios autenticarse contra una API externa (DummyJSON). El backend debe registrar cada autenticación válida en una base de datos PostgreSQL, conservando las cookies y el usuario autenticado.


## Requisitos del proyecto

- **Java 21**: Asegúrate de tener Java 21 instalado y configurado en tu entorno.
- **Spring Boot 3.5.3**: Utiliza la versión 3.5.3 de Spring Boot para el desarrollo.
- **Gradle**: Utiliza Gradle como herramienta de construcción del proyecto.
- **PostgreSQL**: Utiliza PostgreSQL como base de datos para almacenar los registros de autenticación.
- **OpenFeign**: Utiliza OpenFeign para realizar llamadas a la API externa DummyJSON.
- **Docker**: Utiliza Docker para ejecutar el contenedor de PostgreSQL
  y para empaquetar la aplicación como una imagen OCI.

## Ejecución contenedor de base de datos:
Utilizar el siguiente comando para ejecutar un contenedor de PostgreSQL en la raiz del proyecto:

```bash
docker compose up
```

Ejemplo de CURL para probar la autenticación:

```bash
curl --location 'localhost:8080/api/v1/login' \
--header 'X-API-VERSION: 1' \
--header 'Content-Type: application/json' \
--data '{
    "username": "emilys",
    "password": "emilyspass"
}'
```
