FROM maven:3-jdk-8 AS builderimage
FROM gcr.io/distroless/java:11 AS baseimage

FROM builderimage AS builder
WORKDIR /project
COPY . /project
RUN mvn clean package

FROM baseimage AS reportserver
WORKDIR /app
#COPY --from=builder /project/target/someJar.jar /app/app.jar
#CMD ["app.jar"]