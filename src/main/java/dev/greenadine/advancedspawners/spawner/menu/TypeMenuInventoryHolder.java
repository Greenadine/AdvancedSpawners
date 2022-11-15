package dev.greenadine.advancedspawners.spawner.menu;

import net.kyori.adventure.text.Component;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class TypeMenuInventoryHolder implements InventoryHolder {

    private final Inventory menu;

    public TypeMenuInventoryHolder(final AdvancedSpawner spawner) {
        this.menu = createMenu(spawner);
    }

    @Override
    public Inventory getInventory() {
        return menu;
    }

    private Inventory createMenu(final AdvancedSpawner spawner) {
        final Inventory inventory = Bukkit.createInventory(this, 48, Component.text(""));

        // TODO add menu options

        return inventory;
    }
}
