package dev.greenadine.advancedspawners.api.event;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link AdvancedSpawner} is placed by a {@link Player}.
 * <p>
 * If this event is cancelled, the spawner will not be placed.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class AdvancedSpawnerPlaceEvent extends AdvancedSpawnerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    protected boolean cancel;

    protected final Player player;
    protected final Block placedAgainst;
    protected final ItemStack itemInHand;
    protected final EquipmentSlot hand;

    public AdvancedSpawnerPlaceEvent(@NotNull final AdvancedSpawner placedSpawner, @NotNull final Player player, @NotNull final Block placedAgainst, @NotNull final ItemStack itemInHand, @NotNull final EquipmentSlot hand) {
        super(placedSpawner);

        this.player = player;
        this.placedAgainst = placedAgainst;
        this.itemInHand = itemInHand;
        this.hand = hand;
        cancel = false;
    }

    /**
     * Gets the {@link Player} that placed the {@link AdvancedSpawner}.
     *
     * @return The {@code Player} that placed the {@code AdvancedSpawner}.
     */
    @NotNull
    public final Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link AdvancedSpawner} which was just placed. Same as {@link AdvancedSpawnerEvent#getSpawner()}, but can be used for more clarity.
     *
     * @return The placed {@code AdvancedSpawner}.
     */
    @NotNull
    public AdvancedSpawner getSpawnerPlaced() {
        return getSpawner();
    }

    /**
     * Gets the {@link ItemStack} that was in the {@link Player}'s hand when they placed the {@link AdvancedSpawner}.
     *
     * @return The {@code ItemStack} that was in the {@code Player}'s hand when they placed the {@code AdvancedSpawner}.
     */
    @NotNull
    public ItemStack getItemInHand() {
        return itemInHand;
    }

    /**
     * Gets which {@link EquipmentSlot} (hand) placed the {@link AdvancedSpawner}.
     *
     * @return {@link EquipmentSlot#HAND} if the {@code AdvancedSpawner} was placed with the main hand, or
     *         {@link EquipmentSlot#OFF_HAND} if the {@code AdvancedSpawner} was placed with the off-hand.
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
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
