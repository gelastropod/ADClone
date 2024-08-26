package com.example.adclone.Model;

import com.example.adclone.Main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Button extends Group {
    private Rect buttonRect;
    private Text buttonText;
    private Label buttonLabel;
    private boolean hover = false;

    public Button(double x, double y, double w, double h, double arc, String buttonText, boolean confirm)
    {
        buttonRect = new Rect(x, y, w, h, arc);
        getChildren().add(buttonRect);
        buttonRect.getStyleClass().add((confirm ? "confirm" : "cancel") + "-button-rect");
        buttonRect.setCursor(Cursor.HAND);
        buttonRect.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if (confirm)
                    HelperFunctions.fillTransition(Color.rgb(90, 196, 103), Color.rgb(18, 122, 32), 200.0, buttonRect);
                else
                    HelperFunctions.fillTransition(Color.rgb(0, 0, 0), Color.rgb(90, 196, 103), 200.0, buttonRect);
                HelperFunctions.fillTransition(Color.rgb(255, 255, 255), Color.rgb(0, 0, 0), 200.0, Button.this.buttonText);

                hover = true;
            }
        });
        buttonRect.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if (confirm)
                    HelperFunctions.fillTransition(Color.rgb(18, 122, 32), Color.rgb(90, 196, 103), 200.0, buttonRect);
                else
                    HelperFunctions.fillTransition(Color.rgb(90, 196, 103), Color.rgb(0, 0, 0), 200.0, buttonRect);
                HelperFunctions.fillTransition(Color.rgb(0, 0, 0), Color.rgb(255, 255, 255), 200.0, Button.this.buttonText);

                hover = false;
            }
        });

        this.buttonText = new Text(buttonText);
        HelperFunctions.changeColour("-fx-fill", 255, 255, 255, this.buttonText);

        buttonLabel = new Label();
        getChildren().add(buttonLabel);
        buttonLabel.setGraphic(this.buttonText);
        buttonLabel.setMouseTransparent(true);
        buttonLabel.getStyleClass().add((confirm ? "confirm" : "cancel") + "-button-label");
    }

    public void setOnAction(EventHandler<MouseEvent> handler)
    {
        buttonRect.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if (hover)
                    handler.handle(mouseEvent);
            }
        });
    }

    public void finalise()
    {
        HelperFunctions.setScale(buttonRect.getWidth() * 0.6, buttonRect.getHeight() * 0.6, buttonLabel);
        HelperFunctions.setCenter(buttonRect.getCenterX(), buttonRect.getCenterY(), buttonLabel);
    }
}
