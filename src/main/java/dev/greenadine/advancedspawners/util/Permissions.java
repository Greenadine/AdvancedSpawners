package dev.greenadine.advancedspawners.util;

import org.bukkit.entity.EntityType;

public final class Permissions {

    /* Prefixes */
    private static final String PREFIX = "advancedspawners.";
    private static final String SPAWNER_PREFIX = PREFIX + "spawner.";
    private static final String COMMAND_PREFIX = PREFIX + "command.";

    /* Spawner permissions */
    public static final String MINE_SPAWNERS      = SPAWNER_PREFIX + "mine";
    public static final String OPEN_MENU_SPAWNERS = SPAWNER_PREFIX + "menu";
    public static final String UPGRADE_SPAWNERS   = SPAWNER_PREFIX + "upgrade";
    public static final String DISABLE_SPAWNERS   = SPAWNER_PREFIX + "disable";
    public static final String LOCK_SPAWNERS      = SPAWNER_PREFIX + "lock";
    public static final String SHOW_SPAWNER_DELAY = SPAWNER_PREFIX + "showdelay";
    public static final String CHANGE_TYPE_MENU   = SPAWNER_PREFIX + "type.menu";
    public static final String CHANGE_TYPE_EGG    = SPAWNER_PREFIX + "type.egg";
    public static final String CHANGE_TYPES_ALL   = SPAWNER_PREFIX + "types.*";

    /* Command permissions */
    public static final String COMMAND              = PREFIX + "command";
    public static final String COMMAND_SAVE         = COMMAND_PREFIX + "save";
    public static final String COMMAND_RELOAD       = COMMAND_PREFIX + "reload";
    public static final String COMMAND_GIVE         = COMMAND_PREFIX + "give";
    public static final String COMMAND_SET_LEVEL    = COMMAND_PREFIX + "setlevel";
    public static final String COMMAND_SET_TYPE     = COMMAND_PREFIX + "settype";
    public static final String COMMAND_ENABLE       = COMMAND_PREFIX + "enable";
    public static final String COMMAND_DISABLE      = COMMAND_PREFIX + "disable";
    public static final String COMMAND_LOCK         = COMMAND_PREFIX + "lock";
    public static final String COMMAND_UNLOCK       = COMMAND_PREFIX + "unlock";
    public static final String COMMAND_ADMIN_BYPASS = COMMAND_PREFIX + "adminbypass";

    public static String forEntityType(final EntityType entityType) {
        return PREFIX + "spawner.types." + EntityTypeUtils.getSimpleName(entityType);
    }
}
