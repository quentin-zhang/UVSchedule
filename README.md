# UVSchedule

## Windows 打包部署

1.cd D:\GitHubRepository\UVSchedule

2.mvn package

3.cd D:\GitHubRepository\UVSchedule\target

4.java uvschedule-0.0.1-SNAPSHOT.jar

5.docker build -t uvscheduler:0.0.1 .

6.docker run -p 8080:8080 -t --name uvscheduler -d uvscheduler:0.0.1

## Linux 打包部署

1.cd /opt/GithubRepository/UVSchedule/

2.mvn package

3.cd /opt/GithubRepository/UVSchedule/target

4.cp /opt/GithubRepository/UVSchedule/target/uvschedule-0.0.1-SNAPSHOT.jar /usr/local/dockerapp/uvsum/

  cp /opt/GithubRepository/UVSchedule/Dockerfile /usr/local/dockerapp/uvsum/
  
  cd /usr/local/dockerapp/uvsum
  
5.docker build -t uvscheduler:0.0.2 .

6.docker run -p 8080:8080 -t --name uvscheduler -d uvscheduler:0.0.2