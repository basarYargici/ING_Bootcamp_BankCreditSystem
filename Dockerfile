FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR bankCreditSystem-api
COPY --from=build target/*.jar bankCreditSystem-api.jar
ENTRYPOINT ["java", "-jar", "bankCreditSystem-api.jar"]