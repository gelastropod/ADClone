package com.example.adclone;

import com.example.adclone.Model.HelperFunctions;
import com.example.adclone.Model.Screen;
import com.example.adclone.Model.PopUp;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage mainStage;
    private Group escapeConfirmation;
    private Label escapeConfirmationText;

    @Override
    public void start(Stage stage) {
        mainStage = stage;

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

        scene.getStylesheets().add(this.getClass().getResource("View/PopUp.css").toExternalForm());

        mainStage.setScene(scene);
        mainStage.setTitle("Antimatter Dimensions Clone");
        mainStage.setFullScreenExitHint("");
        mainStage.setFullScreen(true);
        mainStage.show();

        editContent(w, h);
    }

    public void handleKeyPress(KeyEvent keyEvent)
    {
        String code = keyEvent.getCode().toString();
        if (code.equals("ESCAPE"))
        {
            escapeConfirmation.setVisible(true);
            mainStage.setFullScreen(true);
        }
    }

    public Parent createContent(int w, int h)
    {
        Group mainArea = new Group();

        Screen screen = new Screen(w / 2, h / 2, w, h);
        mainArea.getChildren().add(screen);
        HelperFunctions.changeColour("-fx-fill", 0, 0, 0, screen);
        screen.setWidth(w);
        screen.setHeight(h);

        escapeConfirmation = new Group();
        escapeConfirmation.setVisible(false);
        mainArea.getChildren().add(escapeConfirmation);

        Rectangle escapeConfirmationPopUp = new Rectangle();
        escapeConfirmation.getChildren().add(escapeConfirmationPopUp);
        escapeConfirmationPopUp.getStyleClass().add("pop-up");
        escapeConfirmationPopUp.setArcWidth(w * 0.01);
        escapeConfirmationPopUp.setArcHeight(w * 0.01);
        escapeConfirmationPopUp.setWidth(w * 0.4);
        escapeConfirmationPopUp.setHeight(h * 0.2);
        escapeConfirmationPopUp.setX(w * 0.3);
        escapeConfirmationPopUp.setY(h * 0.4);

        escapeConfirmationText = new Label("Do you really wish to exit?");
        escapeConfirmation.getChildren().add(escapeConfirmationText);
        HelperFunctions.changeColour("-fx-text-fill", 255, 255, 255, escapeConfirmationText);

        return mainArea;
    }

    public void editContent(double w, double h)
    {
        HelperFunctions.setScale(w * 0.2, h * 0.08, escapeConfirmationText);
        HelperFunctions.setCenter(w * 0.5, h * 0.45, escapeConfirmationText);
    }

    public static void main(String[] args) {
        launch();
    }
}