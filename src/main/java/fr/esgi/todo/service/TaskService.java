package fr.esgi.todo.service;

import java.util.ArrayList;

public interface TaskService {

    public String showTasks();

    public String deleteTask(int id);

    public String addTask(String description);

    public String taskDone(int id);
}
