# Ejemplo de microservicios para prueba tecnica

Este proyecto contiene una arquitectura de microservicios con Spring Boot, MySQL y Nginx usando Docker Compose.

##  Requisitos

* Docker
* Docker Compose
* Java 21+

## Servicios

| Servicio        | Puerto Local | Descripción                                              |
| --------------- | ------------ | -------------------------------------------------------- |
| MySQL           | `3306`       | Base de datos relacional para los microservicios         |
| account-service | `81`         | Servicio de cuentas con ruta base `/api/account-service` |
| client-service  | `82`         | Servicio de clientes con ruta base `/api/client-service` |
| Nginx (proxy)   | `80`         | Reverse proxy que enruta peticiones a los servicios      |


## ¿Cómo levantar todo?

1. Clona el repositorio:

   ```bash
   git clone https://github.com/jerieshg/account-client-services
   cd account-client-services
   ```

2. Levanta todos los servicios:

   ```bash
   gradle build
   docker-compose up --build
   ```

3. Accede desde el navegador:

    * `http://localhost/api/account-service/`
    * `http://localhost/api/client-service/`


## Estructura del proyecto

```
.
├── account-service/
├── client-service/
├── db/
│   └── BaseDatos.sql
├── nginx/
│   └── nginx.conf
├── docker-compose.yml
└── README.md
```

## Comandos

* Detener los servicios:

  ```bash
  docker-compose down
  ```

* Detener y borrar volúmenes:

  ```bash
  docker-compose down -v
  ```
## Postman

Una colleccion de postman con sus ambientes se encuentra en el folder `postman`
