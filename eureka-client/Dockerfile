FROM maven:3.8.5-openjdk-17 as build
WORKDIR /opt/eureka-client

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN mvn package -DskipTests

FROM openjdk:17
ARG DEPENDENCY=/opt/eureka-client/target
COPY --from=build /opt/eureka-client/target/eureka-client-0.0.1-SNAPSHOT.jar /opt/eureka-client-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/opt/eureka-client-0.0.1-SNAPSHOT.jar"]
