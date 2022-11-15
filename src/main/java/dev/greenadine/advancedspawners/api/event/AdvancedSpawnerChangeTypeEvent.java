package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner}'s type is changed.
 * <p>
 * If this event is cancelled, the spawner's type will not be changed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerChangeTypeEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final EntityType previousType;
    protected final Cause cause;

    public AdvancedSpawnerChangeTypeEvent(@NotNull final AdvancedSpawner spawner, @NotNull final EntityType previousType, @NotNull final Cause cause) {
        super(spawner);

        this.previousType = previousType;
        this.cause = cause;
        cancel = false;
    }

    /**
     * Gets the {@link EntityType} prior to the type change.
     *
     * @return The {@code EntityType} prior to the type change.
     */
    @NotNull
    public EntityType getPreviousType() {
        return previousType;
    }

    /**
     * Gets what caused the {@link AdvancedSpawner}'s type to change.
     *
     * @return The {@link Cause} of the type change.
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
        MENU,
        EGG,
        COMMAND,
        PLUGIN,
        UNKNOWN
    }
}
