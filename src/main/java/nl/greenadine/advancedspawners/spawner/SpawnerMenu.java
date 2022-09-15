package nl.greenadine.advancedspawners.spawner;

import net.kyori.adventure.text.Component;
import nl.greenadine.advancedspawners.util.SpawnerMenuInventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author Kevin Zuman
 */
public class SpawnerMenu {

    private final AdvancedSpawner spawner;
    private final Player player;

    private final Inventory menu;

    public SpawnerMenu(final AdvancedSpawner spawner, final Player player) {
        this.spawner = spawner;
        this.player = player;
        this.menu = createMenu(spawner);
    }

    public static Inventory createMenu(final AdvancedSpawner spawner) {
        final Inventory inventory = Bukkit.createInventory(new SpawnerMenuInventoryHolder(spawner), 48, Component.text(""));

        // TODO add menu options

        return inventory;
    }
}
