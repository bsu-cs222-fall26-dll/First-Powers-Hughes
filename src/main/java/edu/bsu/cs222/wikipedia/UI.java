package edu.bsu.cs222.wikipedia;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;


public class UI extends Application{
    Button button;
    public static void main(String[] args){
launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Primary");
        button = new Button();
        button.setText("TEST");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene userInterface = new Scene(layout);
        primaryStage.setScene(userInterface);
        primaryStage.show();


    }


}

