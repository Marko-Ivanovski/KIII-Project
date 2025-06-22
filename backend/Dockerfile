# ---------- 1) Build stage ----------
# Use Maven with Eclipse Temurin JDK 17 to compile & package
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy Maven descriptors and download dependencies first (caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build the fat JAR (skip tests for speed)
COPY src ./src
RUN mvn clean package -DskipTests -B

# ---------- 2) Runtime stage ----------
# Use a slim JRE image to run the packaged JAR
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built JAR from the builder
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Launch the application
ENTRYPOINT ["java", "-jar", "app.jar"]
