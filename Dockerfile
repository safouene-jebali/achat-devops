FROM openjdk:11.0.20.1
EXPOSE 8080
ADD target/achat-1.0.jar achat-1.0.jar
CMD["java","-jar","/achat-1.0.jar"]