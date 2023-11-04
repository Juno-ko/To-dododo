package com.todododogui.todododogui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {

    public TextField newTask;
    @FXML
    private Label showTasks;

    public ObservableList<String> tasks = FXCollections.observableArrayList();
    @FXML
    protected void submitClicked() {
        String taskToBeAdded = newTask.getText();
        tasks.add(taskToBeAdded);
        printTasks(tasks);
    }
    protected void printTasks(ObservableList<String> tasks) {
        StringBuilder taskList = new StringBuilder();

        for (int i = 0; i < tasks.size(); i++) {
            taskList.append((i + 1) + ". " + tasks.get(i) + "\n");
        }
        showTasks.setText(taskList.toString());
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