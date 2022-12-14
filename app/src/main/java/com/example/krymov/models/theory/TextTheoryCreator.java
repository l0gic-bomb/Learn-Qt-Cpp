package com.example.krymov.models.theory;

public class TextTheoryCreator extends TheoryCreator{
    @Override
    public Theory createTheory(String text, String type) {
        return new TextTheory(text, type);
    };
}
