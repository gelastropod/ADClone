package com.example.adclone.Model;

import javafx.scene.Node;

public class HelperFunctions {
    public static int clamp(int lowerBound, int upperBound, int value)
    {
        return Math.min(Math.max(lowerBound, value), upperBound);
    }

    public static void changeColour(String type, int r, int g, int b, Node node)
    {
        String existingCSS = node.getStyle();
        int _r = clamp(0, 255, r);
        int _g = clamp(0, 255, g);
        int _b = clamp(0, 255, b);
        node.setStyle(String.format("%s\n-fx-%s-color: #%02x%02x%02x", existingCSS, type, _r, _g, _b));
    }
}
