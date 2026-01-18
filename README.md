# ScoreboardPlugin

A simple **Scoreboard / UI plugin for Hytale** that provides a central scoreboard system and allows other plugins to update the UI in a clean and controlled way.

This plugin is intended to be used as a **base or shared service plugin**, so other plugins can interact with the scoreboard without depending on internal implementation details.

---

## Features

* Central scoreboard / UI system
* Automatic scoreboard handling for players
* Public API for external plugins
* Update the scoreboard for a single player with variables from other plugins

---

## How to use

1. Download the JAR file
2. Create or open your plugin project
3. Add the JAR file as a library dependency
4. Create and customize the scoreboard (see example below)
5. Update the scoreboard when variables change
6. Make sure the JAR file is placed on your server

---

## Public API

The plugin exposes public methods that can be used by other plugins to update the scoreboard.

### Getting the config 

```java
ScoreboardConfig config = ScoreboardConfigManager.get();
```


### Creating your scoreboard

```java
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
```

You can configure the size, color, and alignment of a field by creating a new ScoreboardField.

```java
new ScoreboardField(ScoreboardFieldType.TEXT, "Text");
```

Make sure to set the ScoreboardFieldType and provide the text that should be displayed.


```java
new ScoreboardField().space(15);
```

You can also create a ScoreboardField without parameters. This type acts as a spacer, and the default spacing value can be adjusted.

---

### Update the scoreboard

```java
UpdateScoreboardListener updateScoreboardListener = new UpdateScoreboardListener();
updateScoreboardListener.updateScoreboard(player);
```

---

## Recommended Usage

* Trigger scoreboard updates when relevant game data changes (e.g. points, level, stats)
* Avoid updating the scoreboard too frequently
* Use the provided API instead of implementing your own UI logic

---

## Pull requests and improvements are welcome.

