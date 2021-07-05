FROM openjdk:16

COPY /*.jar test-0.0.1-SNAPSHOT.jar
EXPOSE 8080

CMD java -jar /test-0.0.1-SNAPSHOT.jar