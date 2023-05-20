FROM openjdk:17-alpine
VOLUME /tmp
WORKDIR /api
ADD target/microservice-product-1.0.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "./app.jar"]
