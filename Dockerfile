FROM maven:3.5-jdk-8-alpine
WORKDIR ./
RUN mvn clean install -DskipTests


FROM java:8
LABEL maintainer=“chathuranga.t@gmail.com”
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]