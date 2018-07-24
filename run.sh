mvn clean package

docker build -t dac/banco ./Postgres
docker build -t dac/core ./coreContato
docker build -t dac/jsf ./jsfContato

docker run -p 5433:5432 -d --name banco dac/banco
docker run -p 8081:8080 -p 3700:3700 -d --name core --link banco:host-banco dac/core
docker run -p 8082:8080 -d --name web --link core:host-core dac/jsf