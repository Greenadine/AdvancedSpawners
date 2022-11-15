package dev.greenadine.advancedspawners.listener;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.greenadine.advancedspawners.api.event.AdvancedSpawnerBreakEvent;
import dev.greenadine.advancedspawners.data.AdvancedSpawnersData;
import dev.greenadine.advancedspawners.AdvancedSpawners;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import dev.greenadine.advancedspawners.util.Permissions;
import dev.greenadine.advancedspawners.util.SpawnerUtils;
import dev.greenadine.advancedspawners.util.Util;
import dev.greenadine.advancedspawners.util.config.ASConfig;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SpawnerBreakListener implements Listener {

    private final Cache<UUID, Object> warnedPlayers = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(1, TimeUnit.HOURS)
            .build();

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBreak(final BlockBreakEvent event) {
        final Block block = event.getBlock();

        // If the block is not a spawner
        if (!(block.getState() instanceof CreatureSpawner)) {
            return;
        }

        final Player player = event.getPlayer();

        // If the player doesn't have permission to mine spawners
        if (!AdvancedSpawners.getPermissions().playerHas(player, Permissions.MINE_SPAWNERS)) {
            return;
        }

        if (!isPickaxe(player.getInventory().getItemInMainHand().getType())) {
            return;
        }

        // If the pickaxe doesn't have silk touch
        if (!player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
            // If players should be warned for attempting to break spawners without silk touch
            if (ASConfig.SILK_TOUCH_WARN) {
                if (!warnedPlayers.asMap().containsKey(player.getUniqueId())) {
                    // TODO send one-time warning to player for attempting to break spawner without silk touch
                    warnedPlayers.put(player.getUniqueId(), new WeakReference<>(new Object()));
                    return;
                }
            }
            return;
        }

        final AdvancedSpawner spawner;

        // If the spawner at the given location doesn't have data
        if (!AdvancedSpawnersData.hasSpawnerData(block.getLocation())) {
            spawner = new AdvancedSpawner(block);
        } else {
            spawner = AdvancedSpawnersData.getSpawnerData(block.getLocation());
        }

        final AdvancedSpawnerBreakEvent spawnerBreakEvent = Util.callEvent(new AdvancedSpawnerBreakEvent(spawner, player));

        // If the event was cancelled
        if (spawnerBreakEvent.isCancelled()) {
            event.setCancelled(true);
            return;
        }

        event.setExpToDrop(0); // Clear dropped EXP because we're dropping the spawner itself
        block.getDrops().clear(); // Clear vanilla drops

        final ItemStack spawnerItem = SpawnerUtils.toItemStack(spawner);

        // TODO drop item
    }

    /**
     * Returns whether the given {@link Material} is a pickaxe.
     *
     * @param material the material.
     *
     * @return {@code true} if, and only if the given material is a pickaxe.
     */
    private boolean isPickaxe(final Material material) {
        return switch (material) {
            case WOODEN_PICKAXE, STONE_PICKAXE, GOLDEN_PICKAXE,
                    IRON_PICKAXE, DIAMOND_PICKAXE, NETHERITE_PICKAXE
                    -> true;
            default -> false;
        };
    }
}
