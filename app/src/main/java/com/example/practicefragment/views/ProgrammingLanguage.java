package com.example.practicefragment.views;

import java.util.HashMap;
import java.util.Map;

enum ProgrammingLanguage {
    EMPTY_LANGUAGE(""),
    CPP("cpp"),
    QT("qt"),
    QML("qml"),
    // Maybe in the future
    JAVA("java"),
    KOTLIN("kotlin");


    private static final Map<String, ProgrammingLanguage> LANGUAGES = new HashMap<>();
    private final String name;

    static {
        for (ProgrammingLanguage programmingLanguage : values()) {
            if (programmingLanguage != EMPTY_LANGUAGE) {
                LANGUAGES.put(programmingLanguage.name, programmingLanguage);
            }
        }
    }

    ProgrammingLanguage(String name) {
        this.name = name;
    }

    public static ProgrammingLanguage getLanguageByName(String name) {
        return LANGUAGES.get(name);
    }

    public String getLanguageName() {
        return name;
    }
}
