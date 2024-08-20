package com.example.adclone;

import com.example.adclone.Model.HelperFunctions;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
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
        if (code.equals("ESCAPE"))
        {

        }
    }

    public Parent createContent(int w, int h)
    {
        GridPane gridPane = new GridPane();
        HelperFunctions.changeColour("background", 0, 0, 0, gridPane);

        Group mainArea = new Group();

        Rectangle escapeConfirmation = new Rectangle();
        escapeConfirmation.setArcWidth(w * 0.05);
        escapeConfirmation.setArcHeight(w * 0.05);
        escapeConfirmation.setWidth(w * 0.5);
        escapeConfirmation.setHeight(h * 0.3);
        escapeConfirmation.setX(w * 0.25);
        escapeConfirmation.setY(h * 0.35);
        mainArea.getChildren().add(escapeConfirmation);

        gridPane.add(mainArea, 1, 0);

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}