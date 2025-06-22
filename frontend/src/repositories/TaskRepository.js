// frontend/src/repositories/TaskRepository.js
import api from '../api/axios';

export const getAllTasks = async () => {
    const response = await api.get('/tasks');
    return response.data;
};

export const getTaskById = async (id) => {
    if (!id) throw new Error('Task ID is required');
    const response = await api.get(`/tasks/${id}`);
    return response.data;
};

export const createTask = async (task) => {
    const response = await api.post('/tasks', task);
    return response.data;
};

export const updateTask = async (id, task) => {
    if (!id) throw new Error('Task ID is required for update');
    const response = await api.put(`/tasks/${id}`, task);
    return response.data;
};

export const deleteTask = async (id) => {
    if (!id) throw new Error('Task ID is required for deletion');
    const response = await api.delete(`/tasks/${id}`);
    return response.data;
};

export const setTaskCompletion = async (id, completed) => {
    if (!id) throw new Error('Task ID is required to set completion');
    const response = await api.patch(
        `/tasks/${id}/completion`,
        null,
        { params: { completed } }
    );
    return response.data;
};
