package com.example.krymov.models.theory;

public interface Theory {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_DEF = 2;
    public static final int TYPE_CODE = 3;

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
