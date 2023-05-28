package fr.esgi.todo.manager;

import fr.esgi.todo.service.impl.TaskServiceImpl;

import java.util.Scanner;

public class TaskManager {
    private static final TaskServiceImpl taskService = new TaskServiceImpl();
    private int branch = 0;

    public int getBranch() {
        return branch;
    }

    public String menu(String userInput) {

        switch (branch) {
            case 0:
                switch (userInput) {
                    case "0":
                        return ("""
                                Menu:
                                1 : Ajouter une tâche
                                2 : Supprimer une tâche
                                3 : Afficher toutes les tâches
                                4 : Marquer une tâche comme terminée
                                exit : Quitter
                                Entrez une option:""");
                    case "1":
                        branch = 1;
                        return ("Entrez une description de tâche:");
                    case "2":
                        branch = 2;
                        return ("Entrez l'id de la tâche à supprimer:");
                    case "3":
                        return (taskService.showTasks()  + "\n" + menu("0"));
                    case "4":
                        branch = 4;
                        return ("Entrez l'id de la tâche à marquer comme terminée :");
                }
            case 1:
                branch = 0;
                return (taskService.addTask(userInput) + "\n" + menu("0"));
            case 2:
                branch = 0;
                int taskIdToRemove = Integer.parseInt(userInput);
                return (taskService.deleteTask(taskIdToRemove)  + "\n" + menu("0"));
            case 4:
                branch = 0;
                int taskIdDone = Integer.parseInt(userInput);
                return (taskService.taskDone(taskIdDone)  + "\n" + menu("0"));

            default:
                return ("Option invalide. Veuillez réessayer.");


        }


    }

}


