package dev.greenadine.advancedspawners.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;

public final class Util {

    public static <T extends Event> T callEvent(final T event) {
        Bukkit.getServer().getPluginManager().callEvent(event);
        return event;
    }

    /**
     * Returns a {@code String} containing information about the given block {@link Location}.
     *
     * @param location the block {@code Location}.
     *
     * @return A {@code String} containing information about the given block {@code Location}.
     */
    public static String blockLocationToString(final Location location) {
        return String.format("World: %s, X: %d, Y: %d, Z: %d", location.getWorld().getName(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }
}
