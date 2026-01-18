package com.xdboy.events;

import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.xdboy.config.ScoreboardConfig;
import com.xdboy.manager.ScoreboardConfigManager;
import com.xdboy.models.ScoreboardField;
import com.xdboy.models.ScoreboardFieldType;

import java.awt.*;

public class PlayerJoinEvent {
    public static void onFirstJoin(PlayerReadyEvent event) {
        Player player = event.getPlayer();

        ScoreboardConfig config = ScoreboardConfigManager.get();

        // TITLE is no different to TEXT at the moment
        config.addField(new ScoreboardField(ScoreboardFieldType.TITLE, "My Hytale Server")
                .size(36)
                .color(Color.CYAN)
                .isCenter(true));
        config.addField(new ScoreboardField().space(5));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Spawn City").color(Color.YELLOW).isCenter(true));
        config.addField(new ScoreboardField().space(15));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Stats").size(26).color(Color.MAGENTA));
        config.addField(new ScoreboardField());
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Rank: Premium"));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Prestige: 1").color(Color.CYAN));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Level: 12").color(Color.GREEN));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Completed Tasks: 7/10"));
        config.addField(new ScoreboardField().space(15));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "Balances").size(26).color(Color.MAGENTA));
        config.addField(new ScoreboardField());
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Silver: 1234").color(Color.GRAY));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Gold: 56").color(Color.YELLOW));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "- Prestige Tokens: 2").color(Color.CYAN));
        config.addField(new ScoreboardField().space(20));
        config.addField(new ScoreboardField(ScoreboardFieldType.TEXT, "www.myserver.net").color(Color.YELLOW).isCenter(true).size(16));

        UpdateScoreboardListener updateScoreboardListener = new UpdateScoreboardListener();
        updateScoreboardListener.updateScoreboard(player);
    }
}
