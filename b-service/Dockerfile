FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY app.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app.jar"]
