# Frontend – KIII Project

This is the React frontend for the KIII Project. It communicates with the backend API to create, update, and display tasks in a user-friendly interface.

## Main Features

- Create and edit tasks
- Mark tasks as completed
- Delete tasks
- Responsive and clean UI

## Running Frontend (Port)

The frontend runs on:
[localhost:5172](http://localhost:5172)


## API Connection

The frontend is configured to connect to the backend at:
[http://localhost:8080](http://localhost:8080)

Make sure the backend is running and accessible before using the UI.

## Configuration

The `axios.js` file sets the API base URL:
```js
const api = axios.create({
  baseURL: 'http://localhost:8080'
});
```

This allows the frontend to make requests to the backend API. Dockerized with a Dockerfile and built using Docker Compose.