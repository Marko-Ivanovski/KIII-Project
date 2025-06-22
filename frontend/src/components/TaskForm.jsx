// frontend/src/components/TaskForm.jsx
import React, { useState, useEffect } from 'react';

export default function TaskForm({ initialTask = {}, onSubmit, onCancel }) {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [dueDate, setDueDate] = useState('');
    const [completed, setCompleted] = useState(false);

    useEffect(() => {
        if (initialTask) {
            setTitle(initialTask.title || '');
            setDescription(initialTask.description || '');
            setDueDate(initialTask.dueDate
                ? initialTask.dueDate.split('T')[0]
                : '');
            setCompleted(Boolean(initialTask.completed));
        }
    }, [initialTask]);

    const handleSubmit = e => {
        e.preventDefault();
        onSubmit({ title, description, dueDate, completed });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div className="mb-4">
                <label htmlFor="title">Title</label>
                <input
                    id="title"
                    type="text"
                    value={title}
                    onChange={e => setTitle(e.target.value)}
                    required
                />
            </div>

            <div className="mb-4">
                <label htmlFor="description">Description</label>
                <textarea
                    id="description"
                    value={description}
                    onChange={e => setDescription(e.target.value)}
                    rows={4}
                />
            </div>

            <div className="mb-4">
                <label htmlFor="dueDate">Due Date</label>
                <input
                    id="dueDate"
                    type="date"
                    value={dueDate}
                    onChange={e => setDueDate(e.target.value)}
                    required
                />
            </div>

            {/* Only show completed toggle in edit mode */}
            {'id' in initialTask && (
                <div className="mb-4">
                    <input
                        type="checkbox"
                        id="completed"
                        checked={completed}
                        onChange={e => setCompleted(e.target.checked)}
                    />
                    <label htmlFor="completed">Completed</label>
                </div>
            )}

            <div className="mb-4">
                {onCancel && (
                    <button
                        type="button"
                        onClick={onCancel}
                        className="secondary"
                    >
                        Cancel
                    </button>
                )}
                <button
                    type="submit"
                    className="primary"
                >
                    Save
                </button>
            </div>
        </form>
    );
}
