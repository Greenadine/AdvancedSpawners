package dev.greenadine.advancedspawners.api.event;

import com.google.common.base.Preconditions;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any {@link Event} related to {@link AdvancedSpawner}s.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public abstract class AdvancedSpawnerEvent extends Event {

    protected final AdvancedSpawner spawner;

    public AdvancedSpawnerEvent(@NotNull final AdvancedSpawner spawner) {
        Preconditions.checkArgument(spawner != null, "Spawner cannot be null.");
        this.spawner = spawner;
    }

    /**
     * Gets the {@link AdvancedSpawner} involved in the {@link Event}.
     *
     * @return The spawner involved in the {@code Event}.
     */
    @NotNull
    public final AdvancedSpawner getSpawner() {
        return spawner;
    }
}
