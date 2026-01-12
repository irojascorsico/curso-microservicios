FROM eclipse-temurin:25-jdk-alpine  AS build

WORKDIR /app

RUN apk add --no-cache maven

COPY . .

RUN mvn clean package -DskipTests -pl microservices/product-microservice -am

FROM eclipse-temurin:25-jre-alpine 
RUN apk add --no-cache curl bash
WORKDIR /app

COPY --from=build /app/microservices/product-microservice/target/*.jar app.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar"]