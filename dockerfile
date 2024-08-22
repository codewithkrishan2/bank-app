# Stage 1: Build the jar file
FROM maven:3.8-jdk-21 AS build
WORKDIR /BANK-APP
COPY . .
RUN mvn clean package

# Stage 2: Create the production image
FROM openjdk:21-jre-slim
WORKDIR /BANK-APP
COPY --from=build /BANK-APP/target/*.jar ./bank-app-1.0.jar
EXPOSE 8080
CMD ["java","-jar","bank-app-1.0.jar"]
