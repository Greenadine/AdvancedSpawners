package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner}'s type is changed by a {@link Player} through the spawner's menu.
 * <p>
 * If this event is cancelled, the spawner's type will not be changed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerMenuChangeTypeEvent extends AdvancedSpawnerChangeTypeEvent {

    protected final Player player;

    public AdvancedSpawnerMenuChangeTypeEvent(@NotNull final AdvancedSpawner spawner, @NotNull final EntityType previousType, @NotNull final Player player) {
        super(spawner, previousType, Cause.MENU);

        this.player = player;
    }

    /**
     * Gets the {@link Player} that changed the {@link AdvancedSpawner}'s type through its menu.
     *
     * @return The {@code Player} that changed the spawner's type.
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }
}
