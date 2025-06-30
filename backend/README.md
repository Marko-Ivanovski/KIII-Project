# Backend – KIII Project

This is the Java Spring Boot backend for the KIII Project. It provides a RESTful API for managing tasks and connects to a PostgreSQL database.

## Main Features

- Task CRUD operations
- Set task completion status
- Integrated with PostgreSQL
- Swagger UI enabled for API testing

## Base URL

The backend API is accessible at:
[http://localhost:8080](http://localhost:8080)

## Swagger UI

Swagger UI is available at:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## 🔧 Endpoints (via `/tasks`)

| Method | Endpoint                                      | Description       |
|--------|-----------------------------------------------|-------------------|
| GET    | `/tasks`                                      | Get all tasks     |
| GET    | `/tasks/{id}`                                 | Get task by ID    |
| POST   | `/tasks`                                      | Create a new task |
| PUT    | `/tasks/{id}`                                 | Update an existing task |
| DELETE | `/tasks/{id}`                                 | Delete a task     |
| PATCH  | `/tasks/{id}/completion?completed=true/false` | Set task completion status |

## Configuration

Environment variables are used for database credentials and connection URL. Dockerized using a Dockerfile and built using Docker Compose.
