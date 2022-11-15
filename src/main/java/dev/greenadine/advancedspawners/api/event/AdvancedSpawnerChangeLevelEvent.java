package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner}'s level is changed.
 * <p>
 * If this event is cancelled, the spawner's level will not be changed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerChangeLevelEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final int previousLevel;

    protected final Cause cause;

    public AdvancedSpawnerChangeLevelEvent(@NotNull final AdvancedSpawner spawner, final int previousLevel, @NotNull final Cause cause) {
        super(spawner);

        this.previousLevel = previousLevel;
        this.cause = cause;
        cancel = false;
    }

    /**
     * Gets the level of the {@link AdvancedSpawner} prior to the level change.
     *
     * @return The level of the spawner prior to the level change.
     */
    public int getPreviousLevel() {
        return previousLevel;
    }

    /**
     * Gets what caused the {@link AdvancedSpawner}'s level to change.
     *
     * @return The {@link Cause} of the level change.
     */
    @NotNull
    public Cause getCause() {
        return cause;
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

    public enum Cause {
        PLACE,
        LEVEL_UP,
        COMMAND,
        PLUGIN,
        UNKNOWN
    }
}
