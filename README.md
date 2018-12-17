# UVSchedule

## Windows 打包部署

1.cd D:\GitHubRepository\UVSchedule

2.mvn package

3.cd D:\GitHubRepository\UVSchedule\target

4.java uvschedule-0.0.1-SNAPSHOT.jar

5.docker build -t uvscheduler:0.0.1 .

6.docker run -p 8080:8080 -t --name uvscheduler -d uvscheduler:0.0.1

## Linux 打包部署

1.cd /opt/githubrepository/UVSchedule/

2.mvn package

3.cp /opt/githubrepository/UVSchedule/target/uvschedule-0.0.1-SNAPSHOT.jar /usr/local/dockerapp/uvsum/

4.cp /opt/githubrepository/UVSchedule/Dockerfile /usr/local/dockerapp/uvsum/
  
5. cd /usr/local/dockerapp/uvsum
  
6. docker build -t uvscheduler:0.0.2 .

### docker 运行

```bash
docker run -p 8080:8080 -t --name uvscheduler -d uvscheduler:0.0.2
```

### docker-compose 运行

```bash
 cd /usr/local/dockerapp/uvsum
 vim docker-compose.yml
docker-compose up -d
#docker-compose down --volume
```


## docker-compose.yml 配置

编辑内容如下：
 
 ```yaml
version: '3'
services:
  uvscheduler:
    image: uvscheduler:0.0.2
    ports:
      - "8080:8080"
    logging:
      driver: gelf
      options:
        gelf-address: udp://xx.xx.xx.xx:12201
        tag: "uvscheduler"
```
