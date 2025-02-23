FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
ADD ./target/microservice-sales-0.0.1-SNAPSHOT.jar microservice-sales.jar
ENTRYPOINT ["java", "-jar", "microservice-sales.jar"]
