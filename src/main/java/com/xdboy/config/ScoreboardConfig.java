package com.xdboy.config;

import com.xdboy.models.ScoreboardField;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardConfig {

    private final List<ScoreboardField> fields = new ArrayList<>();

    public List<ScoreboardField> getFields() {
        return fields;
    }

    public void addField(ScoreboardField field) {
        fields.add(field);
    }

    public void removeLast() {
        if (!fields.isEmpty()) {
            fields.remove(fields.size() - 1);
        }
    }
}
