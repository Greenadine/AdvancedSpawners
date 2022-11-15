package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a setting of a {@link AdvancedSpawner} is changed.
 * <p>
 * If this event is cancelled, the spawner's setting will not be changed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerChangeSettingEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final Player player;
    protected final Setting setting;

    public AdvancedSpawnerChangeSettingEvent(@NotNull final AdvancedSpawner spawner, @NotNull final Player player, @NotNull final Setting setting) {
        super(spawner);

        this.player = player;
        this.setting = setting;
    }

    /**
     * Gets the {@link Player} that changed a setting of the {@link AdvancedSpawner}.
     *
     * @return The {@code Player} that changed a setting of the spawner.
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets which {@link Setting} of the {@link AdvancedSpawner} was changed.
     *
     * @return The {@code Setting} that was changed of the spawner.
     */
    @NotNull
    public Setting getSetting() {
        return setting;
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

    public enum Setting {
        ENABLED,
        LOCKED,
        SHOW_DELAY
    }
}
