FROM openjdk:17
WORKDIR /app
COPY ./target/SpringBoot-0.0.1-SNAPSHOT.jar /app
EXPOSE 8099
CMD ["java", "-jar", "SpringBoot-0.0.1-SNAPSHOT.jar"]