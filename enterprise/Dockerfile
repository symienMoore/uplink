
FROM openjdk:latest
EXPOSE 8080
RUN mvn clean package
ADD target/Uplink-build.jar Uplink-build.jar
ENTRYPOINT ["java", "-jar", "Uplink-build.jar"]

