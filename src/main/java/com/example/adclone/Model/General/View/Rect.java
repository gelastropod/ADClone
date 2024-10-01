package com.example.adclone.Model.General.View;

import javafx.scene.shape.Rectangle;

public class Rect extends Rectangle {
    public Rect(double x, double y, double w, double h, double arc)
    {
        super();
        setWidth(w);
        setHeight(h);
        setX(x - w * 0.5);
        setY(y - h * 0.5);
        setArcWidth(arc);
        setArcHeight(arc);
        getStyleClass().add("rect");
    }

    public double getCenterX()
    {
        return getX() + getWidth() * 0.5;
    }

    public double getCenterY()
    {
        return getY() + getHeight() * 0.5;
    }
}
