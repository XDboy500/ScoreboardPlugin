package com.xdboy;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.xdboy.config.ScoreboardConfig;
import com.xdboy.events.PlayerJoinListener;
import com.xdboy.manager.ScoreboardConfigManager;
import com.xdboy.models.ScoreboardField;
import com.xdboy.models.ScoreboardFieldType;

import javax.annotation.Nonnull;

public class ScoreboardPlugin extends JavaPlugin {

    public ScoreboardPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {

        ScoreboardConfig config = ScoreboardConfigManager.get();

        config.addField(new ScoreboardField(ScoreboardFieldType.TITLE, "HYTALE SERVER"));
        config.addField(new ScoreboardField(ScoreboardFieldType.SPACER, ""));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Spieler: player"));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Coins: coins"));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Level: level"));
        config.addField(new ScoreboardField(ScoreboardFieldType.SPACER, ""));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "example.net"));

        // PlayerJoin creates HUD
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, PlayerJoinListener::onFirstJoin);
    }
}