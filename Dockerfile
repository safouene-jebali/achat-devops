FROM openjdk:11-jre-slim
EXPOSE 8082
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
