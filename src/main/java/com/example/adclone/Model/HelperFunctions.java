package com.example.adclone.Model;

import javafx.animation.FillTransition;
import javafx.scene.Node;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

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
        node.setStyle(String.format("%s\n%s: #%02x%02x%02x;", existingCSS, type, _r, _g, _b));
    }

    public static void setWidth(double width, Node node)
    {
        Bounds bounds = node.getBoundsInLocal();
        double nodeWidth = bounds.getWidth();
        node.setScaleX(width / nodeWidth);
    }

    public static void setHeight(double height, Node node)
    {
        Bounds bounds = node.getBoundsInLocal();
        double nodeHeight = bounds.getHeight();
        node.setScaleY(height / nodeHeight);
    }

    public static void setScale(double prefWidth, double prefHeight, Node node)
    {
        Bounds bounds = node.getBoundsInLocal();
        double nodeWidth = bounds.getWidth();
        double nodeHeight = bounds.getHeight();
        double scaleX = prefWidth / nodeWidth;
        double scaleY = prefHeight / nodeHeight;
        double scale = Math.min(scaleX, scaleY);
        node.setScaleX(scale);
        node.setScaleY(scale);
    }

    public static void setCenter(double x, double y, Node node)
    {
        Bounds bounds = node.getBoundsInLocal();
        double nodeWidth = bounds.getWidth();
        double nodeHeight = bounds.getHeight();
        node.setLayoutX(x - nodeWidth * 0.5);
        node.setLayoutY(y - nodeHeight * 0.5);
    }

    public static void fillTransition(Color colour1, Color colour2, double millis, Shape shape)
    {
        FillTransition fillTransition = new FillTransition();
        fillTransition.setDuration(Duration.millis(millis));
        fillTransition.setFromValue(colour1);
        fillTransition.setToValue(colour2);
        fillTransition.setShape(shape);
        fillTransition.play();
    }
}
