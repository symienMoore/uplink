#FROM maven:3.6.3-jdk-8
#WORKDIR /enterprise/
#COPY ./ ./
#RUN mvn clean package
#CMD ["java", "-jar", "Uplink-build.jar"]

#FROM openjdk:11.0.10
#WORKDIR /enterprise
#EXPOSE 8080
#RUN apt-get update -y && \
#    apt-get upgrade -y && \
#    apt-get install maven -y
#COPY ./ ./
#RUN mvn ./pom.xml clean package
#ADD ./target/uplink-build.jar ./uplink-build.jar
#ENTRYPOINT ["java", "-jar", "uplink-build.jar"]

FROM maven:3.6.3-jdk-8
WORKDIR /enterprise
COPY ./ ./
RUN mvn clean package
CMD ["java", "-jar", "target/uplink-build.jar"]