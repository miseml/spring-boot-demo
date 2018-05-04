FROM java:8

VOLUME /tmp

ADD target/map-application-0.0.1-SNAPSHOT.jar map-application-0.0.1-SNAPSHOT.jar

RUN bash -c 'touch /map-application-0.0.1-SNAPSHOT.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/map-application-0.0.1-SNAPSHOT.jar"]
