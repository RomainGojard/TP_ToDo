package fr.esgi.todo.business;

public class Task {

    private static Long counter = 0L;
    private long id;
    private String description;
    private boolean isDone;

    public Task(String description) {
        isDone = false;
        this.description = description;
        this.id = ++counter;
    }

    public void setDone() {
        this.isDone = true;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
