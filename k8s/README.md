# Kubernetes Manifests – KIII Project

This folder contains all Kubernetes configuration files for deploying the KIII Project's frontend, backend, and PostgreSQL database in a clean and modular structure.

## Structure Overview

### `namespace.yml`
 - Defines a custom namespace `kiii-project` where all resources are deployed.

### `app-config.yml`
 - Application-level configuration passed to the backend via environment variables or ConfigMap.
---

### Backend (`backend/`)

- `backend-deployment.yml`:  
  Deploys the Spring Boot backend application with 3 replicas, using the Docker image `markoivanovsk1/task-backend:latest`.

- `backend-service.yml`:  
  Exposes the backend deployment as a ClusterIP service on port 8080.

---

### Frontend (`frontend/`)

- `frontend-deployment.yml`:  
  Deploys the React frontend application with 3 replicas, using the Docker image `markoivanovsk1/task-frontend:latest`.

- `frontend-service.yml`:  
  Exposes the frontend deployment as a ClusterIP service on port 80.

---

### Database (`database/`)

- `db-credentials.yml`:  
  Defines the PostgreSQL username and password as a Kubernetes Secret.

- `db-service.yml`:  
  Exposes the PostgreSQL StatefulSet as a ClusterIP service on port 5432.

- `db-statefulset.yml`:  
  Deploys a PostgreSQL database using a StatefulSet and connects it to the credentials and service.

---

## Deployment Order

To deploy everything in the correct order:

```bash
kubectl apply -f k8s/namespace.yml
kubectl apply -f k8s/app-config.yml

kubectl apply -f k8s/database/db-credentials.yml
kubectl apply -f k8s/database/db-service.yml
kubectl apply -f k8s/database/db-statefulset.yml

kubectl apply -f k8s/backend/backend-deployment.yml
kubectl apply -f k8s/backend/backend-service.yml

kubectl apply -f k8s/frontend/frontend-deployment.yml
kubectl apply -f k8s/frontend/frontend-service.yml
```

---

## Port Forwarding

To access the frontend and backend services from your local machine, run the following commands:

```bash
kubectl port-forward service/kiii-frontend-service 5172:80 -n kiii-project
kubectl port-forward service/kiii-backend-service 8080:8080 -n kiii-project
```

In your browser, navigate to `http://localhost:5172` for the frontend and `http://localhost:8080` for the backend.

---

## Cleanup

To delete all resources, run the following command:

```bash
kubectl delete -f k8s/database/
kubectl delete -f k8s/backend/
kubectl delete -f k8s/frontend/
kubectl delete -f k8s/app-config.yml
kubectl delete -f k8s/namespace.yml
```

This will delete all resources in the `kiii-project` namespace.

To rollout restart of the deployment, run the following command:

```bash
kubectl rollout restart deployment kiii-frontend -n kiii-project
kubectl rollout restart deployment kiii-backend -n kiii-project
```