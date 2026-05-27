FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8082

ENV SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/test

ENTRYPOINT ["java", "-jar", "app.jar"]