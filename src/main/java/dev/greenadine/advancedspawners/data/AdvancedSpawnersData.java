package dev.greenadine.advancedspawners.data;

import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.Location;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public final class AdvancedSpawnersData {

    private static final ConcurrentHashMap<Location, AdvancedSpawner> SPAWNERS_DATA;

    static {
        SPAWNERS_DATA = new ConcurrentHashMap<>();

        // TODO load spawners data
    }

    /**
     * Gets all the currently loaded-in {@link AdvancedSpawner}s.
     *
     * @return A {@code Collection} containing all the currently loaded-in mob spawners.
     */
    public static Collection<AdvancedSpawner> getSpawnersData() {
        return SPAWNERS_DATA.values();
    }

    /**
     * Gets the {@link AdvancedSpawner} data of the mob spawner at the given {@link Location}.
     *
     * @param location the location.
     *
     * @return The spawner data of the mob spawner at the given location.
     */
    public static AdvancedSpawner getSpawnerData(final Location location) {
        if (!SPAWNERS_DATA.containsKey(location)) {
            SPAWNERS_DATA.put(location, new AdvancedSpawner(location.getBlock()));
        }
        return SPAWNERS_DATA.get(location);
    }

    /**
     * Returns whether there's {@link AdvancedSpawner} data of the block at the given {@link Location}.
     *
     * @param location the location.
     *
     * @return {@code true} if, and only if there's spawner data present for the block at the given location.
     */
    public static boolean hasSpawnerData(final Location location) {
        return SPAWNERS_DATA.containsKey(location);
    }

    /**
     * Deletes the {@link AdvancedSpawner} data of the mob spawner at the given {@link Location}.
     *
     * @param location the location.
     */
    public static void deleteSpawnerData(final Location location) {
        SPAWNERS_DATA.remove(location);
    }

    /**
     * Deletes the {@link AdvancedSpawner} data of the given mob spawner.
     *
     * @param spawner the spawner.
     */
    public static void deleteSpawnerData(final AdvancedSpawner spawner) {
        SPAWNERS_DATA.remove(spawner.getLocation());
    }
}
