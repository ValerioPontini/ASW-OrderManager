#!/bin/bash

gradle build

docker build --rm -t ordermanager-order ./order-service
docker build --rm -t ordermanager-product ./product-service
docker build --rm -t ordermanager-validation ./order-validation-service
docker build --rm -t ordermanager-api-gateway ./api-gateway      

kubectl create namespace order-manager

kubectl apply -f order-manager.yaml -n order-manager
