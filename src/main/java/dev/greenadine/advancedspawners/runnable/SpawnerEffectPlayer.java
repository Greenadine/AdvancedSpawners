package dev.greenadine.advancedspawners.runnable;

import dev.greenadine.advancedspawners.data.AdvancedSpawnersData;
import dev.greenadine.advancedspawners.util.config.ASConfig;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnerEffectPlayer extends BukkitRunnable {

    @Override
    public void run() {
        for (final AdvancedSpawner spawner : AdvancedSpawnersData.getSpawnersData()) {
            // Delete and ignore invalid spawners
            if (!spawner.isValid()) {
                AdvancedSpawnersData.deleteSpawnerData(spawner);
                continue;
            }

            // Ignore disabled spawners
            if (!spawner.isEnabled()) {
                continue;
            }

            // If there are no players within range of the spawner's effect radius
            if (!spawner.getLocation().getNearbyPlayers(ASConfig.EFFECT_RANGE_RADIUS).isEmpty()) {
                continue;
            }

            spawner.getLevel().getEffect().play(spawner); // Play the spawner's effect
        }
    }
}
