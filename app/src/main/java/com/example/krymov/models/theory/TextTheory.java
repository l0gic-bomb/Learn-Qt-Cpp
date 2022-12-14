package com.example.krymov.models.theory;

public class TextTheory implements Theory {

    String text;
    typeTheory type;

    TextTheory(String text, String type)
    {
        super();
        this.text = text;
        this.type = typeTheory.text;
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
