package dev.greenadine.advancedspawners.util;

import com.google.common.collect.HashBiMap;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.LinkedHashMap;

public final class EntityTypeUtils {
    private static final LinkedHashMap<String, EntityType> ENTITY_TYPES = new LinkedHashMap<>();
    private static final HashBiMap<String, EntityType> ENTITY_TYPE_SIMPLE_NAMES = HashBiMap.create();
    private static final LinkedHashMap<EntityType, String> ENTITY_TYPE_DISPLAY_NAMES = new LinkedHashMap<>();

    private static final LinkedHashMap<EntityType, MobSpawnEgg> ENTITY_TYPE_SPAWN_EGGS = new LinkedHashMap<>();

    static {
        // Only retrieve entity types that are alive, while excluding the Wither, Ender Dragon and armor stands
        for (final EntityType entityType : EntityType.values()) {
            if (!entityType.isAlive() || (entityType == EntityType.WITHER || entityType == EntityType.ENDER_DRAGON || entityType == EntityType.ARMOR_STAND)) {
                continue;
            }

            ENTITY_TYPES.put(entityType.name(), entityType);
        }

        mapEntityTypeNames();
        loadEntityTypeSpawnEggs();
    }

    /**
     * Gets the simple name of the {@link EntityType}.
     *
     * @param entityType the entity type.
     *
     * @return The simple name of the entity type.
     */
    public static String getSimpleName(final EntityType entityType) {
        return ENTITY_TYPE_SIMPLE_NAMES.inverse().get(entityType);
    }

    /**
     * Gets the {@link EntityType} from its simple name.
     *
     * @param simpleName the simple name
     *
     * @return The entity type from the given simple name.
     */
    public static EntityType fromSimpleName(final String simpleName) {
        return ENTITY_TYPE_SIMPLE_NAMES.get(simpleName);
    }

    /**
     * Gets the display name of the {@link EntityType}.
     *
     * @param entityType the entity type.
     *
     * @return The display name of the entity type.
     */
    public static String getDisplayName(final EntityType entityType) {
        return ENTITY_TYPE_DISPLAY_NAMES.get(entityType);
    }

    /**
     * Gets the {@link MobSpawnEgg} of the given {@link EntityType}.
     *
     * @param entityType the entity type.
     *
     * @return the
     */
    public static MobSpawnEgg getSpawnEgg(final EntityType entityType) {
        return ENTITY_TYPE_SPAWN_EGGS.get(entityType);
    }

    /**
     * Goes over all {@link EntityType}s and maps their simple- and display names.
     */
    private static void mapEntityTypeNames() {
        for (final EntityType entityType : ENTITY_TYPES.values()) {
            final String name = entityType.name();
            ENTITY_TYPE_SIMPLE_NAMES.put(name.replace("_", "").toLowerCase(), entityType); // E.g. "CAVE_SPIDER" -> "cavespider"

            final String[] strArr = name.split("_");

            final StringBuilder displayName = new StringBuilder();

            // Creates a display name for the entity type (e.g. "CAVE_SPIDER" -> "Cave Spider")
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

                displayName.append(str);

                if (i < strArr.length - 1) {
                    displayName.append(" ");
                }
            }

            ENTITY_TYPE_DISPLAY_NAMES.put(entityType, displayName.toString());
        }
    }

    /**
     * Pre-loads all of the {@link EntityType}s' possible spawn egg items.
     */
    private static void loadEntityTypeSpawnEggs() {
        for (final EntityType entityType : ENTITY_TYPES.values()) {
            final Material spawnEggMaterial;

            if (entityType == EntityType.MUSHROOM_COW) {
                spawnEggMaterial = Material.MOOSHROOM_SPAWN_EGG; // This because of the name discrepancy
            } else {
                try {
                    spawnEggMaterial = Material.valueOf(entityType.name() + "_SPAWN_EGG");
                } catch (IllegalArgumentException ex) { continue; }
            }

            ENTITY_TYPE_SPAWN_EGGS.put(entityType, new MobSpawnEgg(entityType, spawnEggMaterial));
        }
    }

    public record MobSpawnEgg(EntityType entityType, Material spawnEggMaterial) {

        public EntityType getEntityType() {
            return entityType;
        }

        public Material getSpawnEggMaterial() {
            return spawnEggMaterial;
        }

        public String getDisplayName() {
            return ENTITY_TYPE_DISPLAY_NAMES.get(entityType);
        }

        public String getPermission() {
            return Permissions.forEntityType(entityType);
        }
    }
}
