FROM openjdk:8-jdk-alpine
WORKDIR /worker
ARG JAR_FILE=target/worker-0.1.0.jar
COPY ${JAR_FILE} worker.jar
EXPOSE 9090
VOLUME /worker/actions
ENTRYPOINT ["java", "-jar", "/worker.jar"]
