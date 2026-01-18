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
import java.awt.*;

public class ScoreboardPlugin extends JavaPlugin {

    public ScoreboardPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {

        ScoreboardConfig config = ScoreboardConfigManager.get();

        // TITLE is no different to TEXT at the moment
        config.addField(new ScoreboardField(ScoreboardFieldType.TITLE, "My Hytale Server", 36, Color.CYAN));
        config.addField(new ScoreboardField());
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Spawn City", Color.YELLOW));
        config.addField(new ScoreboardField());
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Stats", 26, Color.MAGENTA));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Rank: Premium"));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Prestige: 1", Color.CYAN));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Level: 12", Color.GREEN));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Completed Tasks: 7/10"));
        config.addField(new ScoreboardField());;
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Balances", 26, Color.MAGENTA));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Silver: 1234", Color.GRAY));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Gold: 56", Color.YELLOW));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Prestige Tokens: 2", Color.CYAN));
        config.addField(new ScoreboardField());;
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "www.myserver.net"));

        // PlayerJoin creates HUD
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, PlayerJoinListener::onFirstJoin);
    }
}