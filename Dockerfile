# Java 17 JDK image
FROM eclipse-temurin:17-jdk

# Çalışma dizini
# Java 17 JDK image
FROM eclipse-temurin:17-jdk

# Çalışma dizini
WORKDIR /app

# Tüm dosyaları kopyala
COPY . .

# Linux için gerekli izinleri ver (sadece Linux image içinde çalışır)
RUN ["chmod", "+x", "./mvnw"]

# Maven ile build işlemi
RUN ./mvnw clean package -DskipTests

# JAR dosyasını çalıştır
CMD ["java", "-jar", "target/studentmanager-0.0.1-SNAPSHOT.jar"]
