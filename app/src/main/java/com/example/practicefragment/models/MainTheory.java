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

    public MainTheory(Pair<typeTheory, String> theory) {
        this.theory = theory;
    }

    public Pair<typeTheory, String> getTheory() {
        return theory;
    }

    public void setTheory(Pair<typeTheory, String> theory) {
        this.theory = theory;
    }
}
