package com.example.adclone.Model.Miscellaneous.RichText;

import java.util.ArrayList;

public class RichText
{
    private ArrayList<RichTextToken> tokens = new ArrayList<>();

    private void addToken(RichTextToken token)
    {
        tokens.add(token);
    }

    public static RichText compile(String formatString)
    {
        RichText compiledText = new RichText();
    }
}
