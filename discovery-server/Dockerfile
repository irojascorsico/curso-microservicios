FROM eclipse-temurin:25-jre-alpine 
RUN apk add --no-cache curl bash
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
