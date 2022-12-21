package com.example.krymov.views;


import java.util.HashMap;
import java.util.Map;

public enum Language {

    AUTO(""),

    CPP("cpp"),
    JAVA("java"),
    KOTLIN("kotlin"),
    Q("q"),
    QML("qml");

    private static final Map<String, Language> LANGUAGES = new HashMap<>();
    private final String name;

    static {
        for (Language language : values()) {
            if (language != AUTO) {
                LANGUAGES.put(language.name, language);
            }
        }
    }

    Language(String name) {
        this.name = name;
    }

    public static Language getLanguageByName(String name) {
        return LANGUAGES.get(name);
    }

    public String getLanguageName() {
        return name;
    }
}

