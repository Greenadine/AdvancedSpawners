package dev.greenadine.advancedspawners.util.config;

import dev.greenadine.advancedspawners.exception.NoDefinedSpawnerLevelsException;
import dev.greenadine.advancedspawners.util.config.model.*;
import dev.greenadine.advancedspawners.AdvancedSpawners;
import dev.greenadine.advancedspawners.spawner.SpawnerLevel;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

@SuppressWarnings("ConstantConditions")
public final class ASConfig {

    // General configuration
    public static final String  LANG_FILE = new ConfigString("lang", "en_US").get();
    public static final boolean DEBUG     = new ConfigBoolean("debug", false).get();
    public static final boolean METRICS   = new ConfigBoolean("metrics", true).get();

    // Spawner configuration
    public static final boolean UPGRADE_SPAWNERS       = new ConfigBoolean("upgrade-spawners", true).get();
    public static final boolean USE_ECONOMY            = new ConfigBoolean("use-economy", false).get();
    public static final boolean MINE_SPAWNERS          = new ConfigBoolean("mine-spawners", true).get();
    public static final boolean WITH_SILK_TOUCH        = new ConfigBoolean("with-silk-touch", true).get();
    public static final boolean SILK_TOUCH_WARN        = new ConfigBoolean("silk-touch-warn", true).get();
    public static final double  EFFECT_RANGE_RADIUS    = new ConfigDouble("effect-range-radius", 50d).get();
    public static final boolean PLAY_MAX_LEVEL_EFFECT  = new ConfigBoolean("play-max-level-effect", false).get();
    public static final boolean EGG_CHANGE_TYPE        = new ConfigBoolean("egg-change-type", true).get();
    public static final int     EGG_CHANGE_TYPE_AMOUNT = new ConfigInteger("egg-change-type-amount", 5).get();

    // Spawner menu configuration
    public static final boolean MENU_SOUND_EFFECTS = new ConfigBoolean("menu-sound-effects", true).get();
    public static final boolean MENU_CHANGE_TYPE   = new ConfigBoolean("menu-change-type", true).get();

    // Spawner menu text configuration
    public static final String  MENU_HEADER = new ConfigString("menu-header", "Spawner Menu").get();
    // TODO finish

    // Spawner levels configuration
    private static final HashMap<Integer, SpawnerLevel> LEVELS = new HashMap<>();

    public static SpawnerLevel getSpawnerLevel(final int level) {
        return LEVELS.get(level);
    }

    static {
        // Add default spawner level
        final SpawnerLevel defSpawnerLevel = new SpawnerLevel(0, 0, 500, 500, 4);
        LEVELS.put(-1, defSpawnerLevel);

        // Load configured files
        final FileConfiguration config = AdvancedSpawners.getInstance().getConfig();

        // If configured incorrectly
        if (UPGRADE_SPAWNERS && !config.isConfigurationSection("levels")) {
            Bukkit.getServer().getPluginManager().disablePlugin(AdvancedSpawners.getInstance());
            throw new NoDefinedSpawnerLevelsException();
        }

        // Go through configured levels and load them in
        for (final String str : config.getConfigurationSection("level").getKeys(false)) {
            try {
                final int level = Integer.parseInt(str);
                final ConfigSpawnerLevel configSpawnerLevel = new ConfigSpawnerLevel(level, defSpawnerLevel);
                LEVELS.put(level, configSpawnerLevel.get());
            } catch (NumberFormatException ignored) { }
        }
    }
}
