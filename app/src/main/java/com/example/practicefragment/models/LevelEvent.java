package com.example.practicefragment.models;

// Модель уровней (CppActivity/QtActivity)
public class LevelEvent {
    // TODO enum typeTextLevel
    public static final int HEADER_TYPE = 0;
    public static final int ITEM_TYPE = 1;

    public enum Levels
    {
        JUNIOR,
        MIDDLE,
        SENIOR,
        EMPTY
    }

    private String _header;
    private String _name;
    private String _description;
    private int _type;
    private Levels typeLevel;
    private String id;

    public String get_header() {
        return _header;
    }

    public void setTypeLevel(Levels typeLevel) { this.typeLevel = typeLevel; }

    public String get_name() { return _name; }
    public String get_description() {
        return _description;
    }
    public int get_type() { return _type; }
    public Levels getTypeLevel() { return typeLevel; }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public LevelEvent (String header, String name, String description, int type) {
        _header = header;
        _name = name;
        _description = description;
        _type = type;
    }
}
