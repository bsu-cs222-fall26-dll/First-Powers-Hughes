package edu.bsu.cs222.wikipedia;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;


public class UI extends Application {
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        outputField.setEditable(false);
        configure(primaryStage);
        configureSearchButton();
    }

    private void configure(Stage stage) {
        stage.setTitle("Revisions Search");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private Pane createRoot(){
        VBox root = new VBox();
        root.getChildren().addAll(
                inputField,
                searchButton,
                outputField);
    return root;
    }
    private void configureSearchButton(){
        searchButton.setOnAction(actionEvent -> searchInputFieldWriteOutputField());
    }
    private void searchInputFieldWriteOutputField(){
        WikipediaConnector connector = new WikipediaConnector();


}}

