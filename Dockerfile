FROM gradle:8.6.0-jdk21 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk-7u121-jdk-alpine
COPY --from=build target/generation-postagem-0.0.1-SNAPSHOT.jar generation-postagem-0.0.1-SNAPSHOT.jar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "generation-postagem-0.0.1-SNAPSHOT.jar"]