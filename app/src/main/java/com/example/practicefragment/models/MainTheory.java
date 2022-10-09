package com.example.practicefragment.models;

import android.util.Pair;

// Теория в LevelActivity
public class MainTheory {
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_DEF = 1;
    public static final int TYPE_CODE = 2;

    public enum typeTheory
    {
        text,
        definition,
        code,
        EMPTY
    }

    Pair<typeTheory, String> theory;

    public MainTheory(String type, String theory) {
        this.theory = new Pair<typeTheory, String>(getTypeTheoryByStr(type), theory);
    }

    public Pair<typeTheory, String> getTheory() {
        return theory;
    }

    public void setTheory(Pair<typeTheory, String> theory) {
        this.theory = theory;
    }

    public typeTheory getTypeTheoryByStr(String type)
    {
        if (type.contains("code")) {
            return typeTheory.code;
        }
        else if (type.contains("definition")) {
            return typeTheory.definition;
        }
        else if (type.contains("text")) {
            return typeTheory.text;
        }
        else
            return typeTheory.EMPTY;
    }

    public typeTheory getType()
    {
        return theory.first;
    }

    public String getTextTheory()
    {
        return theory.second.toString();
    }
}
