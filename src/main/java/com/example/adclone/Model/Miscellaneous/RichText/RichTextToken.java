package com.example.adclone.Model.Miscellaneous.RichText;

import com.example.adclone.Model.Miscellaneous.HelperFunctions;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RichTextToken
{
    private String token;
    private Color fontColour;
    private double scale;

    public RichTextToken(String token, Color fontColour, double scale)
    {
        this.token = token;
        this.fontColour = fontColour;
        this.scale = scale;
    }

    public Text renderText()
    {
        Text text = new Text(token);
        HelperFunctions.changeColour("-fx-text-fill", fontColour, text);
        HelperFunctions.setScale(scale, text);
        return text;
    }
}
