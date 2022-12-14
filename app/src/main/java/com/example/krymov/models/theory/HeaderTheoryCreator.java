package com.example.krymov.models.theory;

public class HeaderTheoryCreator extends TheoryCreator{
    @Override
    public Theory createTheory(String text, String type) {
        return new HeaderTheory(text, type);
    }
}
