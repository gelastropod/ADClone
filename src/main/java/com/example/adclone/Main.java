package com.example.adclone;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Screen primaryScreen = Screen.getPrimary();
        Rectangle2D bounds = primaryScreen.getBounds();
        int w = (int)bounds.getWidth();
        int h = (int)bounds.getHeight();

        Parent parent = createContent(w, h);
        Scene scene = new Scene(parent, w, h);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                handleKeyPress(keyEvent);
            }
        });

        stage.setScene(scene);
        stage.setTitle("Antimatter Dimensions Clone");
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();
    }

    public void handleKeyPress(KeyEvent keyEvent)
    {
        String code = keyEvent.getCode().toString();

    }

    public Parent createContent(int w, int h)
    {
        return new GridPane();
    }

    public static void main(String[] args) {
        launch();
    }
}