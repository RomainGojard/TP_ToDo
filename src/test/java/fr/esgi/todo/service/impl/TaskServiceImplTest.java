package fr.esgi.todo.service.impl;

import fr.esgi.todo.business.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TaskServiceImplTest {

    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskServiceImpl();
    }

    @Test
    public void testShowTasks() {
        taskService.addTask("Task 1");
        taskService.addTask("Task 2");

        String expectedOutput = taskService.getTasks().get(0).toString() + "\n" +
                taskService.getTasks().get(1) + "\n";

        Assertions.assertEquals(expectedOutput, taskService.showTasks());
    }

    @Test
    public void testDeleteTask() {
        taskService.addTask("Task 1");
        taskService.deleteTask((int)taskService.getTasks().get(0).getId());
        Assertions.assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void testDeleteTaskWithInvalidId() {
        taskService.addTask("Task 1");

        String deletionResult = taskService.deleteTask(0);

        Assertions.assertEquals("Pas de tâche trouvée pour l'id : 0", deletionResult);

        Assertions.assertNotEquals(0, taskService.getTasks().size());
    }

    @Test
    public void testAddTask() {
        String description = "New Task";

        String addedTaskString = taskService.addTask("New Task");

        Assertions.assertEquals(taskService.getTasks().size(), 1);
        Assertions.assertEquals(taskService.getTasks().get(0).getDescription(), description);
        Assertions.assertFalse(taskService.getTasks().get(0).isDone());
    }

    @Test
    public void testTaskDone() {
        taskService.addTask("Task 1");

        String taskDoneResult = taskService.taskDone( (int) taskService.getTasks().get(0).getId());

        Assertions.assertEquals("Tâche marquée comme finie", taskDoneResult);
        Assertions.assertTrue(taskService.getTasks().get(0).isDone());
    }

    @Test
    public void testTaskDoneWithInvalidId() {
        taskService.addTask("Task 1");

        String taskDoneResult = taskService.taskDone(0);

        Assertions.assertEquals("Pas de tâche trouvée pour l'id : 0", taskDoneResult);
        Assertions.assertFalse(taskService.getTasks().get(0).isDone());
    }
}
