FROM gradle:jdk17-jammy AS build
RUN mkdir -p /home/gradle/cache_home
ENV GRADLE_USER_HOME /home/gradle/cache_home
COPY build.gradle /home/gradle/java-code/
WORKDIR /home/gradle/java-code
RUN gradle clean build -i --stacktrace

FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /home/gradle/java-code/src/build/libs/generation-postagem-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]