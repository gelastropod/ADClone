package com.example.adclone.Model.Miscellaneous.JSON;

public class RegexMatcher
{
    public static boolean isInt(String string)
    {
        return string.matches("\\d+");
    }

    public static boolean isDouble(String string)
    {
        return string.matches("-?([1-9]\\d*|0)(.\\d+)?(e-?[1-9]\\d*)?");
    }

    public static boolean isString(String string)
    {
        return string.matches("['\"].*['\"]");
    }

    public static boolean isBoolean(String string)
    {
        return string.matches("true|false");
    }

    public static boolean isJSON(String string)
    {
        return string.matches("\\{.*}");
    }

    public static String getType(String string)
    {
        if (isInt(string))
            return "int";
        if (isDouble(string))
            return "double";
        if (isString(string))
            return "string";
        if (isBoolean(string))
            return "boolean";
        if (isJSON(string))
            return "json";
        return "invalid";
    }
}
