FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar" , "/spring-boot-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
