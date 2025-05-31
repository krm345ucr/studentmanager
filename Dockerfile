# 1. Aşama: Maven ile derleme
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Aşama: Sadece çalıştırma için JDK
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/studentmanager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
