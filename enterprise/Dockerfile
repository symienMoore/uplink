
FROM maven:3.6.3-jdk-8
WORKDIR /enterprise
COPY ./ ./
RUN mvn clean package
CMD ["java", "-jar", "target/Uplink-build.jar"]

