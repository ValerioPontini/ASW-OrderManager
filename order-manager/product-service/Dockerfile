FROM eclipse-temurin:17-jdk


ADD build/libs/product-service.jar product-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms64m", "-Xmx128m", "-jar", "product-service.jar"]