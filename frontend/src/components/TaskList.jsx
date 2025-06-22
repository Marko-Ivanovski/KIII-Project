// frontend/src/components/TaskList.jsx
import React from 'react';
import TaskItem from './TaskItem';

export default function TaskList({ tasks = [], onEdit, onDelete, onToggleCompleted }) {
    if (tasks.length === 0) {
        return <p className="no-tasks mb-4">No tasks found.</p>;
    }

    return (
        <div className="task-list mb-4">
            {tasks.map(task => (
                <TaskItem
                    key={task.id}
                    task={task}
                    onEdit={onEdit}
                    onDelete={onDelete}
                    onToggleCompleted={onToggleCompleted}
                />
            ))}
        </div>
    );
}
