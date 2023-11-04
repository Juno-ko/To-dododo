package com.todododogui.todododogui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private final ObservableList<String> tasks = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-dododo");

        ListView<String> taskListView = new ListView<>(tasks);
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction(event -> {
            String newTask = newTaskField.getText();
            if (!newTask.isEmpty()) {
                tasks.add(newTask);
                newTaskField.clear();
            }
        });
        newTaskField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String newTask = newTaskField.getText();
                if (!newTask.isEmpty()) {
                    tasks.add(newTask);
                    newTaskField.clear();
                }
            }
        });

        HBox inputBox = new HBox(newTaskField, addButton);
        HBox.setHgrow(newTaskField, Priority.ALWAYS);
        newTaskField.setMaxWidth(Double.MAX_VALUE);

        VBox root = new VBox(taskListView, inputBox);
        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}