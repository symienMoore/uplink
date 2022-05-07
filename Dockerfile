FROM openjdk:latest
WORKDIR /enterprise
EXPOSE 8080
ADD target/Uplink-build.jar Uplink-build.jar
ENTRYPOINT ["java", "-jar", "Uplink-build.jar"]