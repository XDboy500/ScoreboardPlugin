package com.xdboy.manager;

import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

import java.lang.reflect.Method;

final class UiStyleManager {

    private static Method SET_BSON;

    static {
        try {
            SET_BSON = UICommandBuilder.class
                    .getDeclaredMethod("setBsonValue", String.class, BsonValue.class);
            SET_BSON.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("UI internals changed", e);
        }
    }

    static void setStyle(
            UICommandBuilder ui,
            String selector,
            int fontSize,
            String color,
            boolean isCenter
    ) {
        BsonDocument style = new BsonDocument();
        style.put("FontSize", new BsonInt32(fontSize));
        style.put("TextColor", new BsonString(color));

        if (isCenter)
        {
            style.put("Alignment", new BsonString("Center"));
        }

        try {
            SET_BSON.invoke(ui, selector, style);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static void setStyle(
            UICommandBuilder ui,
            String selector,
            int space
    ) {
        BsonDocument style = new BsonDocument();
        style.put("Height", new BsonInt32(space));

        try {
            SET_BSON.invoke(ui, selector, style);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
