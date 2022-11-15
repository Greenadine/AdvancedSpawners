package dev.greenadine.advancedspawners.util;

import net.kyori.adventure.text.Component;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public final class SpawnerUtils {

    /**
     * Returns an {@link ItemStack} representing the given {@link AdvancedSpawner}.
     *
     * @param advancedSpawner the spawner.
     *
     * @return An item representing the given spawner.
     */
    public static ItemStack toItemStack(final AdvancedSpawner advancedSpawner) {
        // TODO start using NBT instead of item meta lore
        // TODO Spigot wiki says that to use NMS run BuildTools for version 1.19.2 locally so that it's under ~/.m2
        final ItemStack itemStack = new ItemStack(Material.SPAWNER);
        final ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.displayName(Component.text(EntityTypeUtils.getDisplayName(advancedSpawner.getSpawnedType()) + " Spawner"));

        // Set item lore
        final ArrayList<Component> lore = new ArrayList<>();
        lore.add(Component.text(ChatColor.GOLD + "Level: " + ChatColor.RESET + advancedSpawner.getLevel()));
        // TODO add spawn count, min -& max spawn delay in NBT tags with NMS

        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
