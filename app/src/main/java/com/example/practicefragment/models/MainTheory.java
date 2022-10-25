package com.example.practicefragment.models;

import android.util.Pair;

import java.util.List;

public class MainTheory {
    public enum typeTheory
    {
        header,
        text_theory,
        definition,
        code,
        EMPTY
    }

    Pair<typeTheory, String> theory;

    public MainTheory(String type, String theory) {
        this.theory = new Pair<typeTheory, String>(getTypeTheoryByStr(type), theory);
    }

    public MainTheory(Pair<typeTheory, String> theory) {
        this.theory = theory;
    }

    public Pair<typeTheory, String> getTheory() {
        return theory;
    }

    public void setTheory(Pair<typeTheory, String> theory) {
        this.theory = theory;
    }

    public typeTheory getTypeTheoryByStr(String type)
    {
        if (type.contains("header")) {
            return typeTheory.header;
        }
        else if (type.contains("code")) {
            return typeTheory.code;
        }
        else if (type.contains("definition")) {
            return typeTheory.definition;
        }
        else if (type.contains("text")) {
            return typeTheory.text_theory;
        }
        else
            return typeTheory.EMPTY;
    }
}
