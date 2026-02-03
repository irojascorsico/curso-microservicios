# Curso Microservicios 

Proyecto Ecommerce:  Incluye varios módulos Spring Boot y la configuración para ejecutar localmente o mediante Docker Compose.

Este proyecto está acompañado por una serie de videos en YouTube donde se explica paso a paso cómo construir y ejecutar microservicios con Spring Boot y Docker Compose:

- [Introducción y Configuración del Proyecto](https://youtu.be/rC5ES1vmRmc?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Config Server](https://youtu.be/D2iwCEKpUws?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Discovery Server (Eureka)](https://youtu.be/MBBl6lIFvPQ?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Microservicio de Clientes](https://youtu.be/CBAVpdqEa4U?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Manejo de Excepciones](https://youtu.be/FOiGQA1mMTM?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Loogging - Logback](https://youtu.be/AFStwdGYHHM?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Microservicio de Productos](https://youtu.be/8G4PzU_4Jzw?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)
- [Orquestación con Docker Compose](https://youtu.be/UQoSrMn96TI?list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4)

> 💡 Revisa la playlist completa aquí: [Curso de Microservicios - Playlist](youtube.com/watch?v=rC5ES1vmRmc&list=PLx89vzy-Ta0pvP5yEdr4KPePSQREJywa4&pp=0gcJCbUEOCosWNinsAgC)


**Estructura Actual**
- **config-server**: servidor de configuración central (archivos en src/main/resources/config/).
- **discovery-server**: servidor de descubrimiento (Eureka/servicio de registro).
- **microservices/**: contiene los microservicios `customer-microservice` y `product-microservice` (cada uno con su propio Dockerfile y configuración).
- **docker-compose.yml**: orquesta los servicios para levantar el sistema completo.

**Requisitos**
- Java JDK 25 instalado.
- Maven 3.6+ (o usar los wrappers `mvnw` / `mvnw.cmd`).
- Docker y Docker Compose.

**Compilar**
Desde la raíz del proyecto ejecutar:

```bash
mvn clean install
```

o con wrapper (Linux/macOS):

```bash
./mvnw clean install
```

en Windows:

```powershell
mvnw.cmd clean install
```

**Ejecutar con Docker Compose**
Para levantar todos los servicios en contenedores:

```bash
docker-compose up --build
```

Para detener:

```bash
docker-compose down
```
