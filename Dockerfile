FROM openjdk:17-alpine
COPY target/factura-0.0.1-SNAPSHOT.jar factura.jar
ENTRYPOINT ["java", "-jar", "factura.jar"]