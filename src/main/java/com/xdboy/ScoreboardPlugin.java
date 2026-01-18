package com.xdboy;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;
import java.awt.*;

public class ScoreboardPlugin extends JavaPlugin {

    public ScoreboardPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        // Example how to create the UI in PlayerJoinEvent
    }
}