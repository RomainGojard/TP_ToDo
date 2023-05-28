package fr.esgi.todo.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Sample task");
    }

    @Test
    public void testTaskInitialization() {
        Assertions.assertEquals("Sample task", task.getDescription());
        Assertions.assertFalse(task.isDone());
    }

    @Test
    public void testTaskSetDone() {
        Assertions.assertFalse(task.isDone());
        task.setDone();
        Assertions.assertTrue(task.isDone());
    }

    @Test
    public void testTaskToString() {
        String expectedToString = "Task{id=" + task.getId() + ", description='Sample task', isDone=false}";
        Assertions.assertEquals(expectedToString, task.toString());
    }
}
