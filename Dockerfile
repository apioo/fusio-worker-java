FROM openjdk:22-slim
WORKDIR /worker
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package
RUN mv ./target/worker-0.1.0.jar ./worker.jar
RUN chmod +x ./worker.jar
EXPOSE 9090
VOLUME /worker/actions
ENTRYPOINT ["java", "-jar", "./worker.jar"]
