# Téléchargement de Maven
FROM maven:3.9.7-eclipse-temurin-21 AS build

# Création du projet
WORKDIR /app

# Copie du projet
COPY . .

# Téléchargement des dépendances & compilation
RUN mvn clean package -DskipTests

# Utilisation d'un JRE pour exécuter le code - Java Runtime Environment
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.war app.war

EXPOSE 8080

#RUN chmod a+x

# Exécuté lors du lacement du container
ENTRYPOINT ["java -jar app.war"]