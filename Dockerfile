# Java 17 imajı
FROM eclipse-temurin:17-jdk

# Çalışma dizinine geç
WORKDIR /app

# Tüm dosyaları kopyala
COPY . .

# Maven Wrapper’a izin ver
RUN chmod +x mvnw

# Derleme (testler atlanır)
RUN ./mvnw clean package -DskipTests

# 8080 portunu expose et
EXPOSE 8080

# .jar dosyasını çalıştır
CMD ["java", "-jar", "target/studentmanager-0.0.1-SNAPSHOT.jar"]
