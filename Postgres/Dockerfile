# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSOWORD 123
ENV POSTGRES_DB dac-bean
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/