package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link Player} opens the menu of a {@link AdvancedSpawner}.
 * <p>
 * If this event is cancelled, the spawner's menu won't be opened for the player.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerOpenMenuEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final Player player;

    public AdvancedSpawnerOpenMenuEvent(@NotNull final AdvancedSpawner spawner, @NotNull final Player player) {
        super(spawner);

        this.player = player;
        cancel = false;
    }

    /**
     * Gets the {@link Player} that opened the {@link AdvancedSpawner}'s menu.
     *
     * @return The {@code Player} that opened the spawner's menu.
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
