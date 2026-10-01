package edu.bsu.cs222.wikipedia;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URISyntaxException;


public class UI extends Application {
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final Label outputFieldLabel = new Label("Output");
    private final Label inputFieldLabel = new Label("Input");
    final TextArea outputField = new TextArea();

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
        stage.setResizable(false);
    }
    private BorderPane createRoot(){
        BorderPane root = new BorderPane();
        root.setLeft(inputField);
        root.setCenter(searchButton);
        root.setBottom(outputField);
        root.setTop(inputFieldLabel);

    return root;
    }
    private void configureSearchButton(){
        searchButton.setOnAction(_ -> {
            try {
                searchInputFieldWriteOutputField();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void searchInputFieldWriteOutputField() throws IOException, URISyntaxException {
        OutputFormatter outputFormatter = new OutputFormatter();
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        if (inputField.getText().isBlank()) {
            outputField.setText("No Page Requested");
            return;
        }
        if(WikipediaConnector.connectToWikipedia(inputField.getText())==null){
            outputField.setText("NetworkError");
            return;
        }
        String output = (outputFormatter.formatOutput(parser.getJsonData(inputField.getText())));
        System.out.println(output);
        outputField.setText(output);



}}

