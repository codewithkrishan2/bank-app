# Stage 1: Build the JAR file
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the production image
FROM eclipse-temurin:17-jdk-alpine AS production
WORKDIR /app
COPY --from=build /app/target/*.jar ./bank-app-1.0.jar
EXPOSE 8080
CMD ["java", "-jar", "bank-app-1.0.jar"]