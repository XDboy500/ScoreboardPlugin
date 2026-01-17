package com.xdboy.models;

public class ScoreboardField {

    public ScoreboardFieldType type;
    public String text;

    public ScoreboardField() {}

    public ScoreboardField(ScoreboardFieldType type, String text) {
        this.type = type;
        this.text = text;
    }
}
