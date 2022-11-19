FROM openjdk:17-alpine
COPY factura-0.0.1-SNAPSHOT.jar factura.jar
ENTRYPOINT ["java", "-jar", "factura.jar"]