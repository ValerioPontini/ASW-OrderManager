#!/bin/bash

kubectl delete -f order-manager.yaml -n order-manager
kubectl delete namespace order-manager