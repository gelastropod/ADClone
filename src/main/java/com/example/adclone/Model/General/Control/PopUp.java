package com.example.adclone.Model.General.Control;

import com.example.adclone.Model.Miscellaneous.HelperFunctions;
import com.example.adclone.Model.General.View.Rect;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PopUp extends Group {
    private Rect popUpRect;
    private Label popUpLabel;
    private Button popUpOptionButton1;
    private Button popUpOptionButton2;

    public PopUp(double x, double y, double w, double h, double arc, String popUpText, String popUpOptionText1, String popUpOptionText2)
    {
        popUpRect = new Rect(x, y, w, h, arc);
        getChildren().add(popUpRect);

        popUpLabel = new Label(popUpText);
        getChildren().add(popUpLabel);

        popUpOptionButton1 = new Button(x - w * 0.25, y + h * 0.25, w * 0.3, h * 0.3, arc, popUpOptionText1, false);
        getChildren().add(popUpOptionButton1);

        popUpOptionButton2 = new Button(x + w * 0.25, y + h * 0.25, w * 0.3, h * 0.3, arc, popUpOptionText2, true);
        getChildren().add(popUpOptionButton2);
        popUpOptionButton2.setOnAction(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                setVisible(false);
            }
        });
    }

    public void setOnAction(EventHandler<MouseEvent> handler)
    {
        popUpOptionButton1.setOnAction(handler);
    }

    public void finalise()
    {
        HelperFunctions.setScale(popUpRect.getWidth() * 0.6, popUpRect.getHeight() * 0.3, popUpLabel);
        HelperFunctions.setCenter(popUpRect.getCenterX(), popUpRect.getY() + popUpRect.getHeight() * 0.25, popUpLabel);

        popUpOptionButton1.finalise();
        popUpOptionButton2.finalise();
    }
}
