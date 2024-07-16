# Use a imagem base do JDK 22
FROM openjdk:22-jdk

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Exponha a porta que a aplicação usa
EXPOSE 8080

# Defina o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
