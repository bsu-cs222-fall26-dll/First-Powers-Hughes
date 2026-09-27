package edu.bsu.cs222.wikipedia;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class UI extends Application {
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
        searchButton.setOnAction(event -> {
            try {
                searchInputFieldWriteOutputField();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void searchInputFieldWriteOutputField() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        String output = (parser.formatOutput(parser.getJsonData(inputField.getText())));
        outputField.setText(output);



}}

