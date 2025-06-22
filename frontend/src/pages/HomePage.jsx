// frontend/src/pages/HomePage.jsx
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import TaskList from '../components/TaskList';
import {
    getAllTasks,
    deleteTask,
    setTaskCompletion
} from '../repositories/TaskRepository';

export default function HomePage() {
    const [tasks, setTasks] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        loadTasks();
    }, []);

    const loadTasks = async () => {
        try {
            const data = await getAllTasks();
            setTasks(data);
        } catch (error) {
            console.error('Failed to fetch tasks', error);
        }
    };

    const handleEdit = id => navigate(`/tasks/${id}/edit`);
    const handleDelete = async id => {
        if (window.confirm('Are you sure you want to delete this task?')) {
            await deleteTask(id);
            loadTasks();
        }
    };
    const handleToggle = async (id, completed) => {
        await setTaskCompletion(id, completed);
        loadTasks();
    };

    return (
        <div className="container">
            <h1 className="mb-4">Task Dashboard</h1>
            <button
                onClick={() => navigate('/tasks/new')}
                className="mb-4"
            >
                + Add Task
            </button>
            <TaskList
                tasks={tasks}
                onEdit={handleEdit}
                onDelete={handleDelete}
                onToggleCompleted={handleToggle}
            />
        </div>
    );
}
