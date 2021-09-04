package com.example.practicefragment.models;

// Модель уровней
public class LevelEvent {
    public static final int HEADER_TYPE = 0;
    public static final int ITEM_TYPE = 1;

    private String _header;
    private String _name;
    private String _description;
    private int _type;

    public String get_header() {
        return _header;
    }

    public void set_header(String _header) {
        this._header = _header;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public String get_name() {
        return _name;
    }

    public String get_description() {
        return _description;
    }

    public int get_type() {
        return _type;
    }

    public LevelEvent (String header, String name, String description, int type) {
        _header = header;
        _name = name;
        _description = description;
        _type = type;
    }
}
