package com.xdboy.models;

import java.awt.Color;

public class ScoreboardField {

    public static final int DEFAULT_SIZE = 20;
    public static final Color DEFAULT_COLOR = Color.WHITE;

    public final ScoreboardFieldType type;
    public final String text;
    public final int size;
    public final Color color;

    public ScoreboardField() {
        this.type = ScoreboardFieldType.SPACER;
        this.text = "";
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    public ScoreboardField(
            ScoreboardFieldType type,
            String text
    ) {
        this.type = type;
        this.text = text;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    public ScoreboardField(
            ScoreboardFieldType type,
            String text,
            Integer size
    ) {
        this.type = type;
        this.text = text;
        this.size = size != null ? size : DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    public ScoreboardField(
            ScoreboardFieldType type,
            String text,
            Color color
    ) {
        this.type = type;
        this.text = text;
        this.size = DEFAULT_SIZE;
        this.color = color != null ? color : DEFAULT_COLOR;
    }

    public ScoreboardField(
            ScoreboardFieldType type,
            String text,
            Integer size,
            Color color
    ) {
        this.type = type;
        this.text = text;
        this.size = size != null ? size : DEFAULT_SIZE;
        this.color = color != null ? color : DEFAULT_COLOR;
    }

    public String getHexColor() {
        return String.format(
                "#%02x%02x%02x%02x",
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                color.getAlpha()
        );
    }

}
