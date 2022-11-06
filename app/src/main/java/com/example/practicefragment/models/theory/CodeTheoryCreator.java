package com.example.practicefragment.models.theory;

public class CodeTheoryCreator extends TheoryCreator{
    @Override
    public Theory createTheory(String text, String type) {
        return new CodeTheory(text, type);
    }
}
