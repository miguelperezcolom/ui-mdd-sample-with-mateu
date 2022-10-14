FROM amazoncorretto:15
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN echo "hello world"
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar","/app.jar"]
