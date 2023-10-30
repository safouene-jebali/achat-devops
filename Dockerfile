FROM openjdk:11-jre-slim
EXPOSE 8089
COPY ./target/achat.jar achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
