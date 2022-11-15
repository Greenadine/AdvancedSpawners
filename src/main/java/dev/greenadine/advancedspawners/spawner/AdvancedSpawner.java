package dev.greenadine.advancedspawners.spawner;

import com.google.common.base.Preconditions;
import dev.greenadine.advancedspawners.util.config.ASConfig;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * Represents a {@link CreatureSpawner} with additional features.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawner {

    protected final Block block;
    protected SpawnerLevel level;

    protected boolean enabled;

    protected AdvancedSpawner(@NotNull final Block spawner, @NotNull final SpawnerLevel level) {
        Preconditions.checkState(spawner.getState() instanceof CreatureSpawner, "Block is no mob spawner.");
        this.block = spawner;
        this.level = level;
    }

    public AdvancedSpawner(@NotNull final Block spawner) {
        this(spawner, ASConfig.getSpawnerLevel(0));
    }

    public AdvancedSpawner(@NotNull final Block spawner, final int level) {
        this(spawner, ASConfig.getSpawnerLevel(level));

        // Configure creature spawner to its level
        setMinSpawnDelay(this.level.getMinSpawnDelay());
        setMaxSpawnDelay(this.level.getMaxSpawnDelay());
        setSpawnCount(this.level.getSpawnCount());
    }

    public AdvancedSpawner(@NotNull final Block spawner, final int level, @Nullable final Integer minSpawnDelay, @Nullable final Integer maxSpawnDelay, @Nullable final Integer spawnCount) {
        this(spawner, ASConfig.getSpawnerLevel(level));

        // Configure creature spawner
        if (minSpawnDelay != null) {
            setMinSpawnDelay(minSpawnDelay);
        }
        if (maxSpawnDelay != null) {
            setMaxSpawnDelay(maxSpawnDelay);
        }
        if (spawnCount != null) {
            setSpawnCount(spawnCount);
        }
    }

    /**
     * Gets the {@link Block} of the spawner.
     *
     * @return The spawner's block.
     */
    @NotNull
    public Block getBlock() {
        return block;
    }

    /**
     * Gets the {@link CreatureSpawner} instance of the spawner.
     *
     * @return The spawner's {@code CreatureSpawner} instance.
     */
    @NotNull
    public final CreatureSpawner getCreatureSpawner() {
        return (CreatureSpawner) block.getState();
    }

    /**
     * Gets the {@link Location} of the spawner.
     *
     * @return The spawner's location.
     */
    @NotNull
    public final Location getLocation() {
        return block.getLocation();
    }

    /**
     * Gets the {@link World} where the spawner is in.
     *
     * @return The spawner's world.
     */
    @NotNull
    public final World getWorld() {
        return block.getWorld();
    }

    /**
     * Gets the X-coordinate of the spawner.
     *
     * @return The spawner's X-coordinate.
     */
    public final int getX() {
        return block.getX();
    }

    /**
     * Gets the Y-coordinate of the spawner.
     *
     * @return The spawner's Y-coordinate.
     */
    public final int getY() {
        return block.getY();
    }

    /**
     * Gets the Z-coordinate of the spawner.
     *
     * @return The spawner's Z-coordinate.
     */
    public final int getZ() {
        return block.getZ();
    }

    /**
     * Gets the current {@link SpawnerLevel} of the spawner.
     *
     * @return The spawner's current level.
     */
    @NotNull
    public final SpawnerLevel getLevel() {
        return level;
    }

    /**
     * Sets the current level of the spawner.
     *
     * @param level the new level.
     */
    public final void setLevel(final int level) {
        this.level = ASConfig.getSpawnerLevel(level);

        // Configure creature spawner
        setMinSpawnDelay(this.level.getMinSpawnDelay());
        setMaxSpawnDelay(this.level.getMaxSpawnDelay());
        setSpawnCount(this.level.getSpawnCount());
    }

    /**
     * Gets the spawned {@link EntityType} for the spawner.
     *
     * @return The spawner's spawned type.
     */
    @NotNull
    public final EntityType getSpawnedType() {
        return getCreatureSpawner().getSpawnedType();
    }

    /**
     * Sets the spawned {@link EntityType} for the spawner.
     *
     * @param type the type.
     */
    public final void setSpawnedType(final EntityType type) {
        getCreatureSpawner().setSpawnedType(type);
    }

    /**
     * Gets the minimum delay (in ticks) of the spawner in between spawn attempts.
     *
     * @return The minimum delay (in ticks) in between spawn attempts.
     */
    public int getMinSpawnDelay() {
        return getCreatureSpawner().getMinSpawnDelay();
    }

    /**
     * Sets the minimum delay (in ticks) of the spawner in between spawn attempts.
     *
     * @param minDelay the minimum delay (in ticks) in between spawn attempts.
     */
    public void setMinSpawnDelay(final int minDelay) {
        getCreatureSpawner().setMinSpawnDelay(minDelay);
    }

    /**
     * Returns whether the spawner has a custom-set minimum spawn delay.
     *
     * @return {@code true} if, and only if the spawner's {@link CreatureSpawner} has a set minimum spawn delay that differs from the spawner's level's minimum spawn delay.
     */
    public boolean hasCustomMinSpawnDelay() {
        return getMinSpawnDelay() != level.getMinSpawnDelay();
    }

    /**
     * Gets the maximum delay (in ticks) of the spawner in between spawn attempts.
     *
     * @return The maximum delay (in ticks) in between spawn attempts.
     */
    public int getMaxSpawnDelay() {
        return getCreatureSpawner().getMaxSpawnDelay();
    }

    /**
     * Sets the maximum delay (in ticks) of the spawner in between spawn attempts.
     *
     * @param maxDelay the maximum delay (in ticks).
     */
    public void setMaxSpawnDelay(final int maxDelay) {
        getCreatureSpawner().setMaxSpawnDelay(maxDelay);
    }

    /**
     * Returns whether the spawner has a custom-set maximum spawn delay.
     *
     * @return {@code true} if, and only if the spawner's {@link CreatureSpawner} has a set maximum spawn delay that differs from the spawner's level's maximum spawn delay.
     */
    public boolean hasCustomMaxSpawnDelay() {
        return getMaxSpawnDelay() != level.getMaxSpawnDelay();
    }

    /**
     * Gets the amount of entities the spawner will attempt to spawn.
     *
     * @return The amount of spawned entities.
     */
    public int getSpawnCount() {
        return getCreatureSpawner().getSpawnCount();
    }

    /**
     * Sets the amount of entities the spawner will attempt to spawn.
     *
     * @param count the amount of spawned entities.
     */
    public void setSpawnCount(final int count) {
        getCreatureSpawner().setSpawnCount(count);
    }

    /**
     * Returns whether the spawner has a custom-set spawn count.
     *
     * @return {@code true} if, and only if the spawner's {@link CreatureSpawner} has a set spawn count that differs from the spawner's level's spawn count.
     */
    public boolean hasCustomSpawnCount() {
        return getSpawnCount() != level.getSpawnCount();
    }

    /**
     * Returns whether the spawner is enabled.
     *
     * @return {@code true} if, and only if the spawner is enabled and is able to spawn entities.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Allows or prevents the spawner from spawning entities.
     *
     * @param enabled {@code true} to allow the spawner to spawn entities, {@code false} to prevent the spawner from spawning entities.
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
        setSpawnCount(enabled ? level.getSpawnCount() : 0);
    }

    /**
     * Returns whether the spawner is still valid.
     *
     * @return {@code true} if, and only if the spawner's {@link Block}'s {@link org.bukkit.block.BlockState} is an instance of {@link CreatureSpawner}.
     */
    public boolean isValid() {
        return block.getState() instanceof CreatureSpawner;
    }
}
