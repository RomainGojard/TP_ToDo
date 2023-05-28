package fr.esgi.todo;

import fr.esgi.todo.manager.TaskManager;
import fr.esgi.todo.service.impl.TaskServiceImpl;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        String userInput = "0";
        System.out.println(taskManager.menu(userInput));
        Scanner scanner = new Scanner(System.in);

        while (!userInput.equals("exit")) {
            userInput = scanner.nextLine();
            System.out.println(taskManager.menu(userInput));
        }
    }
}