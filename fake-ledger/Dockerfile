FROM openjdk:11
RUN apt-get update && apt-get -y dist-upgrade
RUN apt install -y netcat
ADD ["target/fake-ledger-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 8080 8080
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

