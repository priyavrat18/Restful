FROM openjdk:18.0-slim
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]




#docker build -t priyavrat/restful:v1 .
#docker run -d -p 5010:8080 priyavrat/restful:v1