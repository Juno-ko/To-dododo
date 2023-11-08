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
import javafx.util.Callback;

public class HelloApplication extends Application {

    private final ObservableList<TaskItem> tasks = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-dododo");

        ListView<TaskItem> taskListView = getTaskItemListView();

        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction(event -> {
            String newTask = newTaskField.getText();
            if (!newTask.isEmpty()) {
                tasks.add(new TaskItem(newTask));
                newTaskField.clear();
            }
        });

        newTaskField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String newTask = newTaskField.getText();
                if (!newTask.isEmpty()) {
                    tasks.add(new TaskItem(newTask));
                    newTaskField.clear();
                }
            }
        });

        HBox inputBox = new HBox(newTaskField, addButton);
        HBox.setHgrow(newTaskField, Priority.ALWAYS);
        HBox.setHgrow(addButton, Priority.ALWAYS);
        newTaskField.setMaxWidth(Double.MAX_VALUE);

        VBox root = new VBox(taskListView, inputBox);
        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ListView<TaskItem> getTaskItemListView() {
        ListView<TaskItem> taskListView = new ListView<>(tasks);
        taskListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<TaskItem> call(ListView<TaskItem> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(TaskItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.taskName());
                            setGraphic(createDeleteButton(item));
                        } else {
                            setText("");
                            setGraphic(null);
                        }
                    }
                };
            }
        });
        return taskListView;
    }

    private record TaskItem(String taskName) {

        @Override
            public String toString() {
                return taskName;
            }
        }

    private Button createDeleteButton(TaskItem item) {
        Button deleteButton = new Button("XXX");
        deleteButton.setOnAction(event -> tasks.remove(item));
        return deleteButton;
    }
}
