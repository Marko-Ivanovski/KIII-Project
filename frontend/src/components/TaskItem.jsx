// frontend/src/components/TaskItem.jsx
import React from 'react';

export default function TaskItem({ task, onEdit, onDelete, onToggleCompleted }) {
    const { id, title, description, dueDate, completed } = task;

    return (
        <div className={`task-card ${completed ? 'completed' : ''}`}>
            <div>
                <input
                    type="checkbox"
                    checked={completed}
                    onChange={() => onToggleCompleted(id, !completed)}
                />
                <span className="task-title">{title}</span>
                <p>{description}</p>
                <small>Due: {new Date(dueDate).toLocaleDateString()}</small>
            </div>

            <div>
                <button
                    onClick={() => onEdit(id)}
                    className="secondary"
                >
                    Edit
                </button>
                <button
                    onClick={() => onDelete(id)}
                    className="danger"
                >
                    Delete
                </button>
            </div>
        </div>
    );
}
