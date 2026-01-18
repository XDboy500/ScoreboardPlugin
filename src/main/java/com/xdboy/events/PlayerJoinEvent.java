package com.xdboy.events;

import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;

public class PlayerJoinEvent {
    public static void onFirstJoin(PlayerReadyEvent event) {
        Player player = event.getPlayer();
        UpdateScoreboardListener updateScoreboardListener = new UpdateScoreboardListener();
        updateScoreboardListener.updateScoreboard(player);
    }
}
