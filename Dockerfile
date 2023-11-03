FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/achat-devops.jar achat-devops.jar
ENTRYPOINT ["java", "-jar", "/achat-devops.jar"]