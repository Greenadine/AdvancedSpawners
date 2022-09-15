package nl.greenadine.advancedspawners.listener;

import nl.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SpawnerOpenMenuListener implements Listener {

    private final ConcurrentLinkedQueue<AdvancedSpawner> openedMenus = new ConcurrentLinkedQueue<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (event.getClickedBlock() == null ||
                !(event.getClickedBlock().getState() instanceof CreatureSpawner)) {
            return;
        }

        // TODO
    }
}
