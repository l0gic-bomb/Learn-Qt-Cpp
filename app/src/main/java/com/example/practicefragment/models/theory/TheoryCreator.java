package com.example.practicefragment.models.theory;

import com.example.practicefragment.models.MainTheory;

public abstract class TheoryCreator {

    public abstract Theory createTheory(String text, String type);

    public static Theory.typeTheory defineTypeTheory(String type)
    {
        if (type.contains("code")) {
            return Theory.typeTheory.code;
        }
        else if (type.contains("definition")) {
            return Theory.typeTheory.definition;
        }
        else if (type.contains("text")) {
            return Theory.typeTheory.text;
        }
        else
        {
            return Theory.typeTheory.header;
        }
    }
}
