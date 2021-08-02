FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/worker-0.1.0.jar
COPY ${JAR_FILE} worker.jar
ENTRYPOINT ["java", "-jar", "/worker.jar"]
