package com.todododogui.todododogui;

import java.util.Scanner;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tododocli {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<String>();
    
        while (true) {
            System.out.println("");
            System.out.println("-----------");
            System.out.println("To-Do List:");
            System.out.println("-----------");          
            printTasks(tasks);

            System.out.println("\nWhat to do:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Quit");

            Scanner myObj = new Scanner(System.in);
            System.out.println("\nEnter number: ");
            int option = myObj.nextInt();

            switch (option) {
                case 1:
                    addTask(tasks);
                    break;
                case 2:
                    markTaskDone(tasks);
                    break;
                case 3:
                    System.out.println("Quitting.");
                    return;
                default:
                    System.out.println("Please, choice number between 1 - 3.");
            }
        }
    }
    static void printTasks(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    static void addTask(ArrayList<String> tasks) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nAdd new task:");
        String task = myObj.nextLine();
        tasks.add(task);
    }
    static void markTaskDone(ArrayList<String> tasks) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("\nEnter tasks number to mark as done:\n");
        int taskNumber = myObj.nextInt();
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
        }
    }
}
