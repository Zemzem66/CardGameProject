FROM openjdk:11
COPY src/main/java/Server /Connection
WORKDIR /Connection
CMD java com.jetbrains.DriverMangerConnection


