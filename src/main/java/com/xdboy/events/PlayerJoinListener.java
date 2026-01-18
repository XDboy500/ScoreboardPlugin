package com.xdboy.events;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import com.xdboy.manager.ScoreboardConfigManager;
import com.xdboy.manager.UiHudManager;
import com.xdboy.models.ScoreboardField;

import java.util.concurrent.CompletableFuture;

public class PlayerJoinListener {
    public static void onFirstJoin(PlayerReadyEvent event) {
        Player player = event.getPlayer();
        Ref<EntityStore> ref = player.getReference();

        assert ref != null;

        Store<EntityStore> store = ref.getStore();
        PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

        assert playerRef != null;

        World world = player.getWorld();
        assert world != null;

        CompletableFuture.runAsync(() -> {
            if (player.getHudManager().getCustomHud() == null) {
                player.getHudManager().setCustomHud(playerRef, new UiHudManager(playerRef));
                player.sendMessage(Message.raw("HUD Shown"));
            } else {
                player.getHudManager().resetHud(playerRef);
                playerRef.sendMessage(Message.raw("HUD Hidden"));
            }
        }, world);
    }
}
