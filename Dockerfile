FROM openjdk:11.0.20.1
EXPOSE 8089
ADD target/achat.jar achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]