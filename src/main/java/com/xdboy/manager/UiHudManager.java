package com.xdboy.manager;

import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.xdboy.models.ScoreboardField;
import com.xdboy.models.ScoreboardFieldType;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;

import javax.annotation.Nonnull;

public class UiHudManager extends CustomUIHud {
    public UiHudManager(@Nonnull PlayerRef playerRef) {
        super(playerRef);
    }

    @Override
    protected void build(@Nonnull UICommandBuilder ui) {

        ui.append("Hud/ScoreboardRoot.ui");

        int index = 0;

        for (ScoreboardField field : ScoreboardConfigManager.get().getFields()) {

            switch (field.type) {

                case ScoreboardFieldType.TITLE -> {
                    ui.appendInline("#ScoreboardContent", "Group { LayoutMode: Top; Anchor: (Bottom: 0); }");
                    ui.append("#ScoreboardContent[" + index + "]", "Hud/Fields/SelectionTitle.ui");
                    ui.set("#ScoreboardContent[" + index + "] #SectionTitle.Text", field.text);

                    index++;
                }

                case ScoreboardFieldType.TEXT -> {
                    ui.appendInline("#ScoreboardContent", "Group { LayoutMode: Top; Anchor: (Bottom: 0); }");
                    ui.append("#ScoreboardContent[" + index + "]", "Hud/Fields/TextField.ui");
                    ui.set("#ScoreboardContent[" + index + "] #FieldLabel.Text", field.text);

                    UiStyleManager.setStyle(ui, "#ScoreboardContent[" + index + "] #FieldLabel.Style", field.size, field.getHexColor());

                    index++;
                }

                case ScoreboardFieldType.SPACER -> {
                    ui.appendInline("#ScoreboardContent", "Group { LayoutMode: Top; Anchor: (Bottom: 0); }");
                    ui.append("#ScoreboardContent[" + index + "]", "Hud/Fields/Spacer.ui");

                    index++;
                }
            }
        }
    }
}
