FROM gradle:8.6.0-jdk21 as build
COPY . .
RUN mvn clean package -DskipTests

FROM gradle:jdk21-jammy
COPY --from=build target/generation-postagem-0.0.1-SNAPSHOT.jar generation-postagem-0.0.1-SNAPSHOT.jar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "generation-postagem-0.0.1-SNAPSHOT.jar"]