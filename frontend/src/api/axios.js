// frontend/src/axios.js
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080',  // instead of '/api'
});

export default api;
