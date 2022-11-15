package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner} spawns an {@link Entity}.
 * <p>
 * If this event is cancelled, the spawner's level will not be changed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerSpawnEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final Entity entity;

    public AdvancedSpawnerSpawnEvent(final AdvancedSpawner spawner, final Entity entity) {
        super(spawner);

        this.entity = entity;
    }

    /**
     * Gets the {@link Entity} that was spawned by the {@link AdvancedSpawner}.
     *
     * @return The entity that was spawned by the spawner.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Gets the {@link EntityType} of the spawned {@link Entity}.
     *
     * @return The spawned entity's type.
     */
    public EntityType getEntityType() {
        return entity.getType();
    }

    /**
     * Gets the {@link Location} at which the {@link Entity} was spawned.
     *
     * @return The location at which the entity was spawned.
     */
    public Location getLocation() {
        return getEntity().getLocation();
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
