package com.example.practicefragment.models.theory;

public interface Theory {

    public enum typeTheory
    {
        header,
        text,
        definition,
        code
    }

    String getTheory();
    typeTheory getTypeTheory();
}
