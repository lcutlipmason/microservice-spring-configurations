FROM openjdk:8u171-jdk-alpine3.7

ARG JAR_TO_DEPLOY
ARG JAR_TO_DEPLOY_FINAL_NAME
COPY $JAR_TO_DEPLOY /$JAR_TO_DEPLOY_FINAL_NAME
COPY config/ /config
ENV JAVA_OPTS="$JAVA_OPTS -Xms128m -Xmx1024m"

EXPOSE 9070 8443

#due to logback initializing before spring boot, the spring.profiles.active has to be specified on the command line,
#so it's set to read and execute the environment variable executed during docker run.
RUN apk --no-cache add bash && \
echo -e "#!/bin/bash \n java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=\$SPRING_PROFILES_ACTIVE -jar /$JAR_TO_DEPLOY_FINAL_NAME" > ./entrypoint.sh && \
chmod +x ./entrypoint.sh

ENTRYPOINT ["/bin/bash", "-c", "./entrypoint.sh"]
