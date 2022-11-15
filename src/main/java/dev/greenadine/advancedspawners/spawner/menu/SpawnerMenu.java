package dev.greenadine.advancedspawners.spawner.menu;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.entity.Player;

/**
 * @author Kevin Zuman
 */
public class SpawnerMenu {

    private final AdvancedSpawner spawner;
    private final Player player;

    private final MainMenuInventoryHolder mainMenu;
    private final SettingsMenuInventoryHolder settingsMenu;
    private final TypeMenuInventoryHolder typeMenu;

    public SpawnerMenu(final AdvancedSpawner spawner, final Player player) {
        this.spawner = spawner;
        this.player = player;

        this.mainMenu = new MainMenuInventoryHolder(spawner);
        this.settingsMenu = new SettingsMenuInventoryHolder(spawner);
        this.typeMenu = new TypeMenuInventoryHolder(spawner);
    }
}
