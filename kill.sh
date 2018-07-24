docker stop banco
docker kill banco
docker rm banco
docker rmi -f dac/banco

docker stop core
docker kill core
docker rm core
docker rmi -f dac/core

docker stop web
docker stop web
docker kill web
docker rm web
docker rmi -f dac/jsf

mvn clean