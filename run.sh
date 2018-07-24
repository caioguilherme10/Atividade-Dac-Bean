docker build -t dac/dac-banco ./Postgres
docker run -p 5433:5432 -d --name banco dac/dac-banco

mvn clean package
docker build -t dac/core ./coreContato
docker run -p 8081:8080 -d --name core --link banco:host-banco dac/core

mvn clean package
docker build -t dac/jsf ./jsfContato
docker run -p 8082:8080 -d --name web --link core:host-core dac/jsf