package com.example.practicefragment.models;

import android.util.Pair;

import java.util.List;

public class MainTheoryRecyclerView {
    List<MainTheory> theories;

    public void addTheory(MainTheory.typeTheory theory, String text)
    {
        MainTheory tmpTheory = new MainTheory(new Pair<>(theory, text));
        theories.add(tmpTheory);
    }
}
