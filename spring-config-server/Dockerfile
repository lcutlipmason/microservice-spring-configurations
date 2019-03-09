FROM openjdk:8u171-jdk-alpine3.7

ARG JAR_TO_DEPLOY
ARG JAR_TO_DEPLOY_FINAL_NAME
COPY $JAR_TO_DEPLOY /$JAR_TO_DEPLOY_FINAL_NAME
COPY config/ /config
ENV JAVA_OPTS="$JAVA_OPTS -Xms128m -Xmx1024m"

EXPOSE 9080 8443

RUN apk --no-cache add bash && \
apk add --no-cache curl && \
apk add --no-cache jq && \
echo "#!/bin/bash" > ./entrypoint.sh && \
echo "export ECS_INSTANCE_IP_ADDRESS=127.0.0.1" >> ./entrypoint.sh && \
echo "export ECS_INSTANCE_NON_SECURE_PORT=8080" >> ./entrypoint.sh && \
echo '[[ "${ECS_CONTAINER_METADATA_FILE}" ]] &&  export ECS_INSTANCE_IP_ADDRESS=$(curl --retry 5 --connect-timeout 3 -s 169.254.169.254/latest/meta-data/local-ipv4)' >> ./entrypoint.sh && \
echo '[[ "${ECS_CONTAINER_METADATA_FILE}" ]] &&  export ECS_INSTANCE_NON_SECURE_PORT=$(cat ${ECS_CONTAINER_METADATA_FILE} | jq -c -r ".PortMappings[] | select(.ContainerPort == 9080) | .HostPort") fi' >> ./entrypoint.sh && \
echo "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=\$SPRING_PROFILES_ACTIVE -jar /$JAR_TO_DEPLOY_FINAL_NAME" >> ./entrypoint.sh && \
chmod +x ./entrypoint.sh

ENTRYPOINT ["/bin/bash", "-c", "./entrypoint.sh"]