package com.example.adclone.Model;

import javafx.scene.shape.Rectangle;

public class PopUp extends Screen {
    public PopUp(double x, double y, double w, double h, double arc)
    {
        super(x, y, w, h);
        super.setArcWidth(arc);
        super.setArcHeight(arc);
    }
}
