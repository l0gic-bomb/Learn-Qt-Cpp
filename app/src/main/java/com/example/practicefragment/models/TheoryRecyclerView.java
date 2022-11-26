package com.example.practicefragment.models;

import com.example.practicefragment.models.theory.Theory;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class TheoryRecyclerView {
    private List<Theory> theoryList;

    public TheoryRecyclerView() {
        this.theoryList = new ArrayList<>();
    }

    public void setListData (List<Theory> theories) throws JSONException {
        this.theoryList = theories;
    }

    public boolean isEmpty()
    {
        if (theoryList.isEmpty())
            return false;
        return true;
    }

    public List<Theory> getTheories()
    {
        return theoryList;
    }
}
