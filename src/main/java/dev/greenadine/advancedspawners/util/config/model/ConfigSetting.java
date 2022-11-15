package dev.greenadine.advancedspawners.util.config.model;

import dev.greenadine.advancedspawners.AdvancedSpawners;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Super class for plugin configuration settings.
 *
 * @param <T> Which type this setting refers to.
 *
 * @author Kevin Zuman
 */
public abstract class ConfigSetting<T> {

    protected final FileConfiguration config = AdvancedSpawners.getInstance().getConfig();

    protected final String path;
    protected final T def;

    public ConfigSetting(final String path, final T def) {
        this.path = path;
        this.def = def;
    }

    /**
     * Gets the configured value of the setting, or the defined default value if the setting is configured invalidly in the plugin's configuration file.
     *
     * @return The value of the setting, or the default value if no valid value is configured.
     */
    public T get() {
        if (!isValueValid()) {
            return def;
        }
        return getImpl();
    }

    /**
     * Gets the configured value of the setting.
     *
     * @return The setting's configured value.
     */
    protected abstract T getImpl();

    /**
     * Checks whether the value in the plugin configuration is valid for this type of setting.
     *
     * @return {@code true} if, and only if the value in the plugin configuration is a valid value for this type of setting.
     */
    public abstract boolean isValueValid();
}
