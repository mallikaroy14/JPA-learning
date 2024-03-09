FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/jpa-project.jar .
EXPOSE 8080
CMD ["java","-jar","jpa-project.jar"]