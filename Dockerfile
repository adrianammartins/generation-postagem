FROM gradle:8.6.0-jdk21 as build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn package


COPY --from=build /usr/src/app/target/generation-postagem.jar app.jar
CMD["java", "jar", "app.jar"]