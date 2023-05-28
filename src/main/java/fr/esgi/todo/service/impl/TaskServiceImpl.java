package fr.esgi.todo.service.impl;

import fr.esgi.todo.business.Task;
import fr.esgi.todo.service.TaskService;

import java.util.ArrayList;

public class TaskServiceImpl implements TaskService {

    private static ArrayList<Task> tasks = new ArrayList<>();

    public TaskServiceImpl() {
        tasks.clear();
    }

    @Override
    public String showTasks() {
        String show = "";
        for (Task task : tasks
        ) {
            show += task.toString() + "\n";
        }
        return show;
    }

    @Override
    public String deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == (long) id) {
                tasks.remove(task);
                return ("Tâche supprimée");
            }
        }
        return "Pas de tâche trouvée pour l'id : %s".formatted(id);
    }

    @Override
    public String addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        return task.toString();
    }

    @Override
    public String taskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == (long) id) {
                task.setDone();
                return "Tâche marquée comme finie";
            }
        }
        return "Pas de tâche trouvée pour l'id : %s".formatted(id); // No task found with the specified id
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
