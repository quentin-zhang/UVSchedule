# UVSchedule

1.cd D:\GitHubRepository\UVSchedule

2.mvn package

3.cd D:\GitHubRepository\UVSchedule\target

4.java uvschedule-0.0.1-SNAPSHOT.jar

5.docker build -t uvscheduler:0.0.1 .

6.docker run -p 8080:8080 -t --name uvscheduler -d uvscheduler:0.0.1