package dev.greenadine.advancedspawners.listener;

import dev.greenadine.advancedspawners.api.event.AdvancedSpawnerSpawnEvent;
import dev.greenadine.advancedspawners.data.AdvancedSpawnersData;
import dev.greenadine.advancedspawners.util.Util;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class SpawnerSpawnListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onSpawnerSpawn(final SpawnerSpawnEvent event) {
        final AdvancedSpawner spawner = AdvancedSpawnersData.getSpawnerData(event.getLocation());

        // Call event, and cancel Bukkit's spawn event if cancelled
        final AdvancedSpawnerSpawnEvent advancedSpawnerSpawnEvent = Util.callEvent(new AdvancedSpawnerSpawnEvent(spawner, event.getEntity()));
        event.setCancelled(advancedSpawnerSpawnEvent.isCancelled());
    }
}
