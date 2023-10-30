package com.todododogui.todododogui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {

    public TextField newTask;
    @FXML
    private Label showTasks;
    @FXML
    protected void submitClicked() {
        String taskToBeAdded = newTask.getText();
        showTasks.setText("1. " + taskToBeAdded);
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