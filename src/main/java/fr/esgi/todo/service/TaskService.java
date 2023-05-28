package fr.esgi.todo.service;

import fr.esgi.todo.business.Task;

import java.util.ArrayList;

public interface TaskService {
    public ArrayList<Task> getTasks();

    public String showTasks();

    public String deleteTask(int id);

    public String addTask(String description);

    public String taskDone(int id);
}
