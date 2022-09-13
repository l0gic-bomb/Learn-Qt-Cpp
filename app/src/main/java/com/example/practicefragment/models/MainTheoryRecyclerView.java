package com.example.practicefragment.models;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MainTheoryRecyclerView {
    List<MainTheory> theories;

    public MainTheoryRecyclerView() {
        this.theories = new ArrayList<>();
    }

    public void addTheory(MainTheory.typeTheory theory, String text)
    {
        MainTheory tmpTheory = new MainTheory(new Pair<>(theory, text));
        theories.add(tmpTheory);
    }

    public void setListData (List<MainTheory>[] theories) {
        for (int i = 0; i < theories.length; ++i)
        {
            this.theories.add((MainTheory) theories[i]);
        }
    }

    public boolean isEmpty()
    {
        if (theories.isEmpty())
            return false;
        return true;
    }

}
