#!/bin/bash

gradle build

docker build --rm -t ordermanager-order ./order-service
docker build --rm -t ordermanager-product ./product-service
docker build --rm -t ordermanager-validation ./order-validation-service
docker build --rm -t ordermanager-api-gateway ./api-gateway      

docker-compose up -d