package com.example.adclone.Model.Miscellaneous.JSON;

public class JSONValue<T>
{
    private T value;

    public JSONValue(T value)
    {
        this.value = value;
    }

    public T get()
    {
        return value;
    }

    public static JSONValue<?> getValue(String string)
    {

    }
}
