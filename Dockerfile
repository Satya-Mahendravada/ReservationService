#Start with a base image containing Java runtime
FROM openjdk:17-slim as build

#Information around who maintains the image
MAINTAINER hotelmanagement.com

#Add the application's jar to container
ADD target/reservation-service-0.0.1-SNAPSHOT.jar reservation-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "/reservation-service-0.0.1-SNAPSHOT.jar"]