package com.example.adclone.Model;

import javafx.scene.shape.Rectangle;

public class Screen extends Rectangle {
    public Screen(double x, double y, double w, double h)
    {
        super();
        super.setWidth(w);
        super.setHeight(h);
        super.setX(x - w * 0.5);
        super.setY(y - h * 0.5);
    }
}
