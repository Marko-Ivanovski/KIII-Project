# KIII Project – Full Stack Task Manager

This is a full-stack task management app developed for the KIII course. It uses Spring Boot, React, and PostgreSQL, fully containerized and orchestrated with Docker and Kubernetes, and integrates CI/CD with GitHub Actions and Docker Hub.

## Features

- REST API to manage tasks
- Modern React frontend
- PostgreSQL for persistent storage
- Swagger UI for API testing
- CI/CD pipeline with GitHub Actions

## Technologies Used

### 1. Back-End:
- Java Spring Boot – https://spring.io/projects/spring-boot
- Swagger UI – https://swagger.io/tools/swagger-ui/

### 2. Front-End:
- React – https://reactjs.org/
- Node.js – https://nodejs.org/

### 3. Database:
- PostgreSQL – https://www.postgresql.org/

### 4. Containerization & Orchestration:
- Docker – https://www.docker.com/
- Docker Desktop (with built-in Kubernetes) – https://www.docker.com/products/docker-desktop/
- Docker Hub – https://www.docker.com/products/docker-hub/
- Docker Compose – https://docs.docker.com/compose/
- Kubernetes – https://kubernetes.io/

### 5. Source Control and CI/CD:
- Git – https://git-scm.com/
- GitHub – https://github.com/
- GitHub Actions – https://github.com/features/actions

## Project Structure

- `/backend` – Spring Boot backend with task controller and Swagger API
- `/frontend` – React app using Axios to connect to backend
- `/k8s` – All Kubernetes manifests grouped by service
- `docker-compose.yml` – Local development environment
- `.github/workflows/ci-cd.yml` – GitHub Actions CI/CD pipeline
