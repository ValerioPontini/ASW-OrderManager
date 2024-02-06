FROM eclipse-temurin:17-jdk


ADD build/libs/order-service.jar order-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms64m", "-Xmx128m", "-jar", "order-service.jar"]