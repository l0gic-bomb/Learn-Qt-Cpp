package com.example.krymov.models.theory;

public class HeaderTheory implements Theory{
    String text;
    typeTheory type;

    HeaderTheory(String text, String type)
    {
        super();
        this.text = text;
        this.type = typeTheory.header;
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
