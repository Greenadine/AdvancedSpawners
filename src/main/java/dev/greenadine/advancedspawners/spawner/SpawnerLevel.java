package dev.greenadine.advancedspawners.spawner;

import org.bukkit.Effect;
import org.bukkit.Particle;

/**
 * Represents a configured level for {@link AdvancedSpawner}s.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class SpawnerLevel {

    private final int level;
    private final int cost;
    private final int minSpawnDelay;
    private final int maxSpawnDelay;
    private final int spawnCount;
    private final SpawnerEffect effect;

    private SpawnerLevel(final int level, final int cost, final int minSpawnDelay, final int maxSpawnDelay, final int spawnCount, final SpawnerEffect effect) {
        this.level = level;
        this.cost = cost;
        this.minSpawnDelay = minSpawnDelay;
        this.maxSpawnDelay = maxSpawnDelay;
        this.spawnCount = spawnCount;
        this.effect = effect;
    }

    public SpawnerLevel(final int level, final int cost, final int minSpawnDelay, final int maxSpawnDelay, final int spawnCount) {
        this.level = level;
        this.cost = cost;
        this.minSpawnDelay = minSpawnDelay;
        this.maxSpawnDelay = maxSpawnDelay;
        this.spawnCount = spawnCount;
        this.effect = new SpawnerEffect(SpawnerEffect.Type.NONE, null);
    }

    public SpawnerLevel(final int level, final int cost, final int minSpawnDelay, final int maxSpawnDelay, final int spawnCount, final Effect effect) {
        this(level, cost, minSpawnDelay, maxSpawnDelay, spawnCount, new SpawnerEffect(SpawnerEffect.Type.EFFECT, effect.name()));
    }

    public SpawnerLevel(final int level, final int cost, final int minSpawnDelay, final int maxSpawnDelay, final int spawnCount, final Particle particle) {
        this(level, cost, minSpawnDelay, maxSpawnDelay, spawnCount, new SpawnerEffect(SpawnerEffect.Type.PARTICLE, particle.name()));
    }

    public int asInt() {
        return level;
    }

    public int getCost() {
        return cost;
    }

    public int getMinSpawnDelay() {
        return minSpawnDelay;
    }

    public int getMaxSpawnDelay() {
        return maxSpawnDelay;
    }

    public int getSpawnCount() {
        return spawnCount;
    }

    public SpawnerEffect getEffect() {
        return effect;
    }
}
