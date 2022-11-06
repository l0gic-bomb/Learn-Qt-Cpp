package com.example.practicefragment.models.theory;

public class DefenitionTheory implements Theory{
    String text;
    typeTheory type;

    DefenitionTheory(String text, String type)
    {
        super();
        this.text = text;
        this.type = typeTheory.definition;
    }

    @Override
    public String getTheory() {
        return text;
    }

    @Override
    public typeTheory getTypeTheory() {
        return type;
    }
}
