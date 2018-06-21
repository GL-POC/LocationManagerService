FROM openjdk:8-jdk-alpine
EXPOSE 9001
VOLUME /tmp
ARG build/libs/
ADD location-manager-service-0.0.1-SNAPSHOT.jar location-manager-service-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /location-manager-service-0.0.1-SNAPSHOT.jar