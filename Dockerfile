FROM maven:latest

WORKDIR /var/data/maven

COPY springboot-demo /var/data/maven

RUN maven package -Dmaven.test.skip=true

FROM java:latest

WORKDIR /usr/local/web/

COPY --from=0 /tmp/springboot-demo/target/springboot-demo-0.0.1-SNAPSHOT.jar .

CMD [ "java" "-jar" "springboot-demo-0.0.1-SNAPSHOT.jar"]

