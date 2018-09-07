FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY uvschedule-0.0.1-SNAPSHOT.jar app.jar
RUN echo -e "https://mirrors.ustc.edu.cn/alpine/latest-stable/main" > /etc/apk/repositories && \
    apk update &&\
    apk --no-cache add tzdata && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" >  /etc/timezone
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]