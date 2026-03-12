FROM eclipse-temurin:25-jre-alpine 
RUN apk add --no-cache curl bash
WORKDIR /app

COPY target/*.jar app.jar

# Exponer el puerto del Config Server
EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar"]