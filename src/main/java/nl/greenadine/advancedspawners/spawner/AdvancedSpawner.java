package nl.greenadine.advancedspawners.spawner;

import nl.greenadine.advancedspawners.data.AdvancedSpawnersData;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

/**
 * @author Kevin Zuman
 */
public class AdvancedSpawner {

    private CreatureSpawner spawner;
    private SpawnerLevel level;

    public AdvancedSpawner(final CreatureSpawner spawner) {
        this.spawner = spawner;
        this.level = AdvancedSpawnersData.ofLevel(0);
    }

    public AdvancedSpawner(final Location location, final int level) {
        final Block block = location.getWorld().getBlockAt(location);

        if (!(block.getState() instanceof CreatureSpawner)) {
            // TODO log invalid block state
        }

        this.spawner = (CreatureSpawner) block.getState();
        this.level = AdvancedSpawnersData.ofLevel(level);
    }

    /**
     * Gets the {@link CreatureSpawner} instance of the spawner.
     *
     * @return The spawner's {@code CreatureSpawner} instance.
     */
    public final CreatureSpawner getCreatureSpawner() {
        return spawner;
    }

    /**
     * Gets the {@link Location} of the spawner.
     *
     * @return The spawner's {@code Location}.
     */
    public final Location getLocation() {
        return spawner.getLocation();
    }

    /**
     * Gets the current {@link SpawnerLevel} of the spawner.
     *
     * @return The spawner's current {@code SpawnerLevel}.
     */
    public final SpawnerLevel getLevel() {
        return level;
    }

    /**
     * Sets the current level of the spawner.
     *
     * @param level the new level.
     */
    public final void setLevel(final int level) {
        this.level = AdvancedSpawnersData.ofLevel(level);

        // TODO set min/max delays according to new level's configuration
    }

    /**
     * Changes the spawned {@link EntityType} for the spawner.
     *
     * @param type the {@code EntityType}.
     */
    public final void setSpawnedType(final EntityType type) {
        spawner.setSpawnedType(type);
    }

    /**
     * Sets the average amount of {@link org.bukkit.entity.Entity}s the spawner will spawn.
     *
     * @param count the average amount of {@code Entity}s.
     */
    private void setSpawnCount(final int count) {
        spawner.setSpawnCount(count);
    }

    /**
     * Sets the minimum delay (in seconds) between each spawn attempt.
     *
     * @param minDelay the minimum delay (in seconds).
     */
    private void setMinSpawnDelay(final int minDelay) {
        spawner.setMinSpawnDelay(minDelay);
    }

    /**
     * Sets the maximum delay (in seconds) between each spawner attempt.
     *
     * @param maxDelay the maximum delay (in seconds).
     */
    private void setMaxSpawnDelay(final int maxDelay) {
        spawner.setMaxSpawnDelay(maxDelay);
    }
}
