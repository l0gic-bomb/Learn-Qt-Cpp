package com.example.practicefragment.models.theory;

public class CodeTheory implements Theory{
    String text;
    typeTheory type;
    // TODO when will be ready codeView need to add type language

    CodeTheory(String text, String type)
    {
        super();
        this.text = text;
        this.type = typeTheory.code;
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
