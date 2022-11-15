package dev.greenadine.advancedspawners.util;

import dev.greenadine.advancedspawners.AdvancedSpawners;
import dev.greenadine.advancedspawners.util.config.ASConfig;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public final class Lang {

    private static final AdvancedSpawners instance = AdvancedSpawners.getInstance();

    private static YamlConfiguration LANG;

    //public static final String PREFIX;

    // TODO add everything

    public static boolean load() {
        // Load in configured lang file
        Logger.debug("Setting up message table...");
        String fileName = ASConfig.LANG_FILE;
        File file = new File(instance.getDataFolder() + File.separator + "lang" + File.separator + fileName + ".yml");

        boolean saveDefaults = false;

        for (int i = 0; i < 2; i++) { // Twice because we want it to retry with default if it can't find the configured file
            if (file.exists()) {
                break;
            }

            if (fileName.equals("en_US")) {
                Logger.debug("Couldn't find default language file 'en_US.yml', creating new one...");
                AdvancedSpawners.getInstance().saveResource("en_US.yml", false);
                // Make sure it doesn't attempt it again unnecessarily
                if (saveDefaults) {
                    break;
                } else {
                    // Attempt to load in the default/configured file
                    final InputStream defConfigStream = instance.getResource(instance.getDataFolder() + File.separator + "lang" + File.separator + "en_US.yml");
                    if (defConfigStream != null) {
                        File defaultLangFile = new File(instance.getDataFolder(), File.separator + "lang" + File.separator + "en_US.yml");
                        YamlConfiguration defaultLangConfig = YamlConfiguration.loadConfiguration(defaultLangFile);

                        try {
                            defaultLangConfig.save(file);
                        } catch (IOException ex) {
                            Logger.error(Level.SEVERE, ex, "Failed to load default language file 'en_US'. This is a fatal error, disabling plugin...");
                            return false;
                        }
                    }
                    saveDefaults = true;
                }
            } else {
                Logger.logf(Level.WARNING, "Couldn't find language file '%s'. Defaulting to 'en_US'...", ASConfig.LANG_FILE + ".yml");
                fileName = "en_US";
                file = new File(instance.getDataFolder() + File.separator + "lang" + File.separator + fileName + ".yml");
            }
        }

        // TODO finish
        return true;
    }

    private static void saveDefaults(final boolean saveDefaults) {

    }

    public static class LangEntry {

        private final String path;
        private final String def;

        public LangEntry(final String path, final String def) {
            this.path = path;
            this.def = def;
        }

        public String toString() {
            if (!LANG.contains(path)) {
                LANG.set(path, def);
                // TODO saveDefaults = true;
            }
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
        }
    }
}
