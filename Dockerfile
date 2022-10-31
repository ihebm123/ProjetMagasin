FROM openjdk:8-jdk-alpine
EXPOSE 8095
ADD target/ProjetMagasin.jar ProjetMagasin.jar
ENTRYPOINT ["java","-jar","/ProjetMagasin.jar"]