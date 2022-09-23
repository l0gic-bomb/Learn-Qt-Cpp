package com.example.practicefragment.models;

import static android.media.CamcorderProfile.get;

import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainTheoryRecyclerView {
    List<MainTheory> theories;

    public MainTheoryRecyclerView() {
        this.theories = new ArrayList<>();
    }

    public void addTheory(MainTheory.typeTheory theory, String text)
    {
        MainTheory newTheory = new MainTheory(new Pair<>(theory, text));
        theories.add(newTheory);
    }

    public void setListData (String[] theories) throws JSONException {
        for (int i = 0; i < theories.length; ++i)
        {
            JSONObject Jsonobject = new JSONObject();
            JSONArray jsonArray = Jsonobject.getJSONArray(theories[i]);
            for (int j = 0; j < jsonArray.length(); ++j)
            {
                // ЗДЕСЬ НУЖНО ЗАПИСАТЬ ТЕОРИЮ
                String elem = jsonArray.get(j).toString();
                MainTheory.typeTheory type = checkTypeData(elem);

            }

           // this.theories.add((MainTheory) theories[i]);
        }
    }

    public boolean isEmpty()
    {
        if (theories.isEmpty())
            return false;
        return true;
    }

    private MainTheory.typeTheory checkTypeData (String string)
    {
        MainTheory.typeTheory type;
        // TODO bad move
        char firstLetter = string.charAt(0);
        switch (firstLetter) {
            case 'h':
                type = MainTheory.typeTheory.header;
                break;
            case 't':
                type = MainTheory.typeTheory.text_theory;
                break;
            case 'd':
                type = MainTheory.typeTheory.definition;
                break;
            case 'c':
                type = MainTheory.typeTheory.code;
                break;
            default:
                type = MainTheory.typeTheory.EMPTY;
                break;
        }

        return type;
    }

}
