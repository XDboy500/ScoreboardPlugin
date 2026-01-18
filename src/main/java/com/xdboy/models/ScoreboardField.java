package com.xdboy.models;

import java.awt.Color;

public class ScoreboardField {

    public static final int DEFAULT_SIZE = 20;
    public static final Color DEFAULT_COLOR = Color.WHITE;
    public static final boolean DEFAULT_CENTER = false;
    public static final int DEFAULT_SPACE = 8;

    public final ScoreboardFieldType type;
    public final String text;

    private int size = DEFAULT_SIZE;
    private Color color = DEFAULT_COLOR;
    private boolean isCenter = DEFAULT_CENTER;
    private int space = DEFAULT_SPACE;

    public ScoreboardField() {
        this.type = ScoreboardFieldType.SPACER;
        this.text = "";
    }

    public ScoreboardField(ScoreboardFieldType type, String text) {
        this.type = type;
        this.text = text;
    }

    public ScoreboardField size(int size) {
        this.size = size;
        return this;
    }

    public ScoreboardField color(Color color) {
        if (color != null) {
            this.color = color;
        }
        return this;
    }

    public ScoreboardField isCenter(boolean isCenter) {
        if (isCenter) {
            this.isCenter = isCenter;
        }
        return this;
    }

    public ScoreboardField space(int space) {
        this.space = space;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public boolean getIsCenterValue() {
        return isCenter;
    }

    public int getSpace() {
        return space;
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
