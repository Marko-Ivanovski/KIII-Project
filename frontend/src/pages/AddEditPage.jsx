// frontend/src/pages/AddEditTaskPage.jsx
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import TaskForm from '../components/TaskForm';
import {
    getTaskById,
    createTask,
    updateTask
} from '../repositories/TaskRepository';

export default function AddEditTaskPage() {
    const { id } = useParams();
    const navigate = useNavigate();
    const [initialTask, setInitialTask] = useState({});

    useEffect(() => {
        if (id) {
            (async () => {
                try {
                    const task = await getTaskById(id);
                    setInitialTask(task);
                } catch (error) {
                    console.error('Failed to fetch task', error);
                }
            })();
        }
    }, [id]);

    const handleSubmit = async taskData => {
        try {
            if (id) {
                await updateTask(id, taskData);
            } else {
                await createTask(taskData);
            }
            navigate('/');
        } catch (error) {
            console.error('Save failed', error);
        }
    };

    const handleCancel = () => navigate('/');

    return (
        <div className="container">
            <h1 className="mb-4">
                {id ? 'Edit Task' : 'Add Task'}
            </h1>
            <TaskForm
                initialTask={initialTask}
                onSubmit={handleSubmit}
                onCancel={handleCancel}
            />
        </div>
    );
}
