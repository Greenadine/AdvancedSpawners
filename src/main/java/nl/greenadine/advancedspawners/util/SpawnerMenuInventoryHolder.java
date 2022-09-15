package nl.greenadine.advancedspawners.util;

import nl.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class SpawnerMenuInventoryHolder implements InventoryHolder {

    private final AdvancedSpawner spawner;

    public SpawnerMenuInventoryHolder(final AdvancedSpawner spawner) {
        this.spawner = spawner;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    public final AdvancedSpawner getSpawner() {
        return spawner;
    }
}
