FROM openjdk:11
RUN apt-get update && apt-get -y dist-upgrade
RUN apt install -y netcat
ADD ["target/fake-payments-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 8083 8083
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
RUN sh -c 'touch /app.jar'
RUN apt install -y netcat
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


