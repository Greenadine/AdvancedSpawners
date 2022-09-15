package nl.greenadine.advancedspawners.data;

import nl.greenadine.advancedspawners.spawner.AdvancedSpawner;
import nl.greenadine.advancedspawners.spawner.SpawnerLevel;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class AdvancedSpawnersData {

    private static final ConcurrentHashMap<Location, AdvancedSpawner> SPAWNERS_DATA;
    private static final HashMap<Integer, SpawnerLevel> LEVELS_DATA;

    static {
        SPAWNERS_DATA = new ConcurrentHashMap<>();
        LEVELS_DATA = new HashMap<>();

        // TODO load levels data
        // TODO load spawners data

        // TODO make sure there's always a default level (level 0)
    }

    /**
     * Gets the {@link SpawnerLevel} based on the given level.
     *
      * @param level the level.
     *
     * @return The {@code SpawnerLevel} based on the given level.
     */
    public static SpawnerLevel ofLevel(final int level) {
        if (!LEVELS_DATA.containsKey(level)) {
            // TODO log missing/invalid level
            return LEVELS_DATA.get(0);
        }
        return LEVELS_DATA.get(level);
    }
}
