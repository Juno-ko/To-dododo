package com.todododogui.todododogui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Tododocli extends Application {

    private ObservableList<String> tasks = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List App");

        ListView<String> taskListView = new ListView<>(tasks);
        Button addButton = new Button("Lisää tehtävä");

        addButton.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setContentText("Tehtävä:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newTask -> tasks.add(newTask));
        });

        taskListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);

                    Button deleteButton = new Button("X");
                    deleteButton.setOnAction(event -> {
                        tasks.remove(item);
                    });

                    setGraphic(deleteButton);
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }
        });

        VBox root = new VBox(taskListView, addButton);
        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
