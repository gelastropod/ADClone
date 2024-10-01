package com.example.adclone.Model.General.View;

import javafx.scene.paint.Paint;

public class TextRect
{
    private Rect mainRect;

    public TextRect(double x, double y, double w, double h, double arc, String text, double fontSize, Paint colour)
    {
        mainRect = new Rect(x, y, w, h, arc);

    }
}
