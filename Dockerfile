FROM openjdk:8-jdk-alpine
ARG JAR_FILE=out/artifacts/worker_jar/worker.jar
COPY ${JAR_FILE} worker.jar
ENTRYPOINT ["java", "-jar", "/worker.jar"]
