FROM openjdk:11-jre-slim
EXPOSE 8089
ADD target/achat.jar achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]