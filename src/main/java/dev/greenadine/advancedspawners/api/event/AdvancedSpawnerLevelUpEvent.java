package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner} is leveled up by a {@link Player}.
 * <p>
 * If this event is cancelled, the spawner's level will not be raised, and no XP/money will be deducted from the {@code Player}.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerLevelUpEvent extends AdvancedSpawnerChangeLevelEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final Player player;

    public AdvancedSpawnerLevelUpEvent(@NotNull final AdvancedSpawner spawner, @NotNull final Player player) {
        super(spawner, spawner.getLevel().asInt() - 1, Cause.LEVEL_UP);

        this.player = player;
        cancel = false;
    }

    /**
     * Gets the {@link Player} that leveled up the {@link AdvancedSpawner}.
     *
     * @return The {@code Player} that leveled up the spawner.
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /* Event implementation */

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /* Cancellable implementation */

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
