FROM openjdk:latest
WORKDIR /opt/docker
ADD opt /opt
#RUN ["chown", "-R", "daemon:daemon", "."]
USER payne-web
ENTRYPOINT ["./run.sh"]
