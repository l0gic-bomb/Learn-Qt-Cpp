package com.example.practicefragment.models;

// Модель уровней
public class LevelEvent {
    public static final int HEADER_TYPE = 0;
    public static final int ITEM_TYPE = 1;

    private String _nameLevels[], _descs[];
    private int _images[];
    private String _header;
    private int _type;

    public String[] get_nameLevels() {
        return _nameLevels;
    }
    public String[] get_descs() {
        return _descs;
    }
    public int[] get_images() {
        return _images;
    }
    public String get_header() {
        return _header;
    }
    public int get_type() { return _type; }

    public LevelEvent(String[] _nameLevels, String[] _descs, int[] _images, String _header, int type ) {
        this._nameLevels = _nameLevels;
        this._descs = _descs;
        this._images = _images;
        this._header = _header;
        this._type   = type;
    }

    public void set_nameLevels(String[] _nameLevels) {
        this._nameLevels = _nameLevels;
    }



    public void set_descs(String[] _descs) {
        this._descs = _descs;
    }
    public void set_images(int[] _images) {
        this._images = _images;
    }
    public void set_header(String _header) {
        this._header = _header;
    }
    public void set_type(int _type) { this._type = _type; }
}
