package nl.greenadine.advancedspawners.spawner;

/**
 * @author Kevin Zuman
 */
public class SpawnerLevel {

    private final int level;
    private final int minSpawnDelay;
    private final int maxSpawnDelay;

    public SpawnerLevel(final int level, final int minSpawnDelay, final int maxSpawnDelay) {
        this.level = level;
        this.minSpawnDelay = minSpawnDelay;
        this.maxSpawnDelay = maxSpawnDelay;
    }

    public int asInt() {
        return level;
    }

    public int getMinSpawnDelay() {
        return minSpawnDelay;
    }

    public int getMaxSpawnDelay() {
        return maxSpawnDelay;
    }
}
