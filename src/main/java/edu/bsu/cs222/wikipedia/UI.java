package edu.bsu.cs222.wikipedia;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class UI extends Application {
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final Label outputField = new Label();

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
        configureSearchButton();
    }

    private void configure(Stage stage) {
        stage.setTitle("Revisions Search");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private BorderPane createRoot(){
        BorderPane root = new BorderPane();
        root.setTop(inputField);
        root.setCenter(searchButton);
        root.setBottom(outputField);
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
        String output = (parser.formatOutput(parser.getJsonData(inputField.getText()),parser.getJsonData(inputField.getText())));
        System.out.println(output);
        outputField.setText(output);



}}

