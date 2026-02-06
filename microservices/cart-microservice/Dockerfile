FROM eclipse-temurin:25-jdk-alpine  AS build

WORKDIR /app

# Instalar Maven directamente en Alpine
RUN apk add --no-cache maven

COPY . .

RUN mvn clean package -DskipTests -pl microservices/cart-microservice -am

FROM eclipse-temurin:25-jre-alpine 
RUN apk add --no-cache curl bash
WORKDIR /app

COPY --from=build /app/microservices/cart-microservice/target/*.jar app.jar

# Exponer el puerto del Config Server
EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar"]