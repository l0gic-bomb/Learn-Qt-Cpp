package com.example.practicefragment.models.theory;

public class DefenitionTheoryCreator extends TheoryCreator{
    @Override
    public Theory createTheory(String text, String type) {
        return new DefenitionTheory(text, type);
    }
}
