# --- ETAPA 1: Compilación ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
# Copiar el pom y descargar dependencias para aprovechar la caché de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar el archivo .jar saltando los tests (ya los validamos)
COPY src ./src
RUN mvn clean package -DskipTests

# --- ETAPA 2: Runtime seguro ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Restricción de seguridad: Crear un usuario del sistema para no correr como root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el .jar generado desde la etapa de compilación
COPY --from=build /app/target/API_Specimen-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]