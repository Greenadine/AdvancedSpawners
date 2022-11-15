package dev.greenadine.advancedspawners.listener;

import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnerPlaceListener implements Listener {

    public void onBlockPlace(final BlockPlaceEvent event) {
        final Block block = event.getBlock();

        // If the block is not a spawner
        if (!(block.getState() instanceof CreatureSpawner)) {
            return;
        }

        final Player player = event.getPlayer();
    }
}
