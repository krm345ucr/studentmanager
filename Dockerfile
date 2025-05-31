# Temel JDK imajı
FROM eclipse-temurin:17-jdk

# Uygulama dizinine geç
WORKDIR /app

# Tüm proje dosyalarını kopyala
COPY . .

# Maven script'ine çalıştırma izni ver
RUN chmod +x ./mvnw

# Testleri tamamen atlayarak derleme yap
RUN ./mvnw clean package -Dmaven.test.skip=true

# Uygulama portunu aç
EXPOSE 8080

# Uygulama jar dosyasını çalıştır
CMD ["java", "-jar", "target/studentmanager-0.0.1-SNAPSHOT.jar"]
