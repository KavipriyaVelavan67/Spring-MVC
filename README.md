docker build -t spring-mvc .

docker run -d -p 8083:8080 --name spring-mvc1 spring-mvc

docker ps
