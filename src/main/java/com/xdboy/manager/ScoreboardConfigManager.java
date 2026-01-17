package com.xdboy.manager;

import com.xdboy.config.ScoreboardConfig;

public final class ScoreboardConfigManager {

    private static final ScoreboardConfig CONFIG = new ScoreboardConfig();

    public static ScoreboardConfig get() {
        return CONFIG;
    }
}
