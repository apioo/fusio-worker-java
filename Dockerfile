FROM openjdk:22-slim
WORKDIR /worker
COPY . .
RUN chmod +x ./mvnw
EXPOSE 9090
VOLUME /worker/actions
ENTRYPOINT ["./mvnw", "clean", "spring-boot:run"]
