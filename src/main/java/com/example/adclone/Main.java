package com.example.adclone;

import com.example.adclone.Model.HelperFunctions;
import com.example.adclone.Model.PopUp;
import com.example.adclone.Model.Rect;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage mainStage;
    private PopUp escapeConfirmationPopUp;

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

        scene.getStylesheets().add(this.getClass().getResource("View/Rect.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("View/FontStyle.css").toExternalForm());

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
            escapeConfirmationPopUp.setVisible(true);
            mainStage.setFullScreen(true);
        }
    }

    public Parent createContent(int w, int h)
    {
        Group mainArea = new Group();

        Rect rect = new Rect(w / 2, h / 2, w, h, 0.0);
        mainArea.getChildren().add(rect);
        HelperFunctions.changeColour("-fx-stroke", 0, 0, 0, rect);
        rect.setWidth(w);
        rect.setHeight(h);

        escapeConfirmationPopUp = new PopUp(w * 0.5, h * 0.5, w * 0.4, h * 0.2, w * 0.01, "Do you really wish to exit?", "Exit", "Cancel");
        mainArea.getChildren().add(escapeConfirmationPopUp);
        escapeConfirmationPopUp.setVisible(false);
        escapeConfirmationPopUp.setOnAction(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                mainStage.close();
            }
        });

        return mainArea;
    }

    public void editContent(double w, double h)
    {
        escapeConfirmationPopUp.finalise();
    }

    public static void main(String[] args) {
        launch();
    }
}