package com.example.practicefragment.models;

import static android.media.CamcorderProfile.get;

import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainTheoryRecyclerView {
    private List<MainTheory> theories;

    public MainTheoryRecyclerView() {
        this.theories = new ArrayList<>();
    }

    public void setListData (List<MainTheory> theories) throws JSONException {
        this.theories = theories;
    }

    public List<MainTheory> getTheories()
    {
        return theories;
    }

    public boolean isEmpty()
    {
        if (theories.isEmpty())
            return false;
        return true;
    }

}
