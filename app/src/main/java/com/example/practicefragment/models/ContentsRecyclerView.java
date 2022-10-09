package com.example.practicefragment.models;

import java.util.ArrayList;
import java.util.List;

public class ContentsRecyclerView {
    private List<ContentsTheory> contents;

    public ContentsRecyclerView() {
        this.contents = new ArrayList<>();
    }

    public void setListData (String[] theories) {
        for (int i = 0; i < theories.length; ++i)
        {
            ContentsTheory result = new ContentsTheory(theories[i]);
            contents.add(result);
        }
    }

    public String[] getContentData()
    {
        if (contents.isEmpty())
            return null;

        String[] strings = new String[contents.size()];
        for (int i = 0; i < contents.size(); ++i)
        {
            strings[i] = contents.get(i).getNameContent();
        }
        return strings;
    }

    public boolean isEmpty()
    {
        if (contents.isEmpty())
            return false;
        return true;
    }
}
