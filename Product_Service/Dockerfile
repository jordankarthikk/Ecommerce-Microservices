FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/Product_Service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 2222

ENTRYPOINT ["java","-jar","app.jar"]