FROM eclipse-temurin:17-jdk


ADD build/libs/order-validation-service.jar order-validation-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms64m", "-Xmx128m", "-jar", "order-validation-service.jar"]