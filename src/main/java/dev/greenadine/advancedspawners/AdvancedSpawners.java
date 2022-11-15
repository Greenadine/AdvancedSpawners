package dev.greenadine.advancedspawners;

import co.aikar.commands.PaperCommandManager;
import dev.greenadine.advancedspawners.command.AdvancedSpawnersCommand;
import dev.greenadine.advancedspawners.listener.SpawnerBreakListener;
import dev.greenadine.advancedspawners.listener.SpawnerSpawnListener;
import dev.greenadine.advancedspawners.runnable.SpawnerEffectPlayer;
import dev.greenadine.advancedspawners.util.Logger;
import dev.greenadine.advancedspawners.util.config.ASConfig;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class AdvancedSpawners extends JavaPlugin {

    private static AdvancedSpawners instance;

    private static Economy economy;
    private static Permission permissions;
    private static boolean useHolographicDisplays;

    private static PaperCommandManager commandManager;

    private static Metrics metrics;

    @Override
    public void onEnable() {
        // Check if Vault is installed, and if not disable plugin
        if (!getServer().getPluginManager().isPluginEnabled("Vault")) {
            Logger.log(Level.SEVERE, "Vault is necessary for the plugin to function, but is not present in the server. Disabling plugin...");
            setEnabled(false);
            return;
        }

        instance = this;
        metrics = new Metrics(this, 16442);

        saveDefaultConfig(); // Save default config if no config exists

        // Setup Vault permissions
        if (!setupPermissions()) {
            Logger.log(Level.SEVERE, "Failed to load Vault permissions. Disabling plugin...");
            setEnabled(false);
            return;
        }

        // Setup Vault economy if needed
        if (setupEconomy()) {
            Logger.log("Hooked into Vault economy for spawner upgrades");
        }

        // Determine whether HolographicDisplays should be used
        if (getServer().getPluginManager().isPluginEnabled("HolographicDisplays")) {
            Logger.log("HolographicDisplays found, enabling hologram features");
            useHolographicDisplays = true;
        }

        // Schedule effect player
        new SpawnerEffectPlayer().runTaskTimer(this, 0L, 20L);

        setupCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setupListeners() {
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new SpawnerSpawnListener(), this);

        if (ASConfig.MINE_SPAWNERS) {
            manager.registerEvents(new SpawnerBreakListener(), this);
        }
    }

    private void setupCommands() {
        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new AdvancedSpawnersCommand());
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> serviceProvider = getServer().getServicesManager().getRegistration(Permission.class);
        if (serviceProvider == null) {
            return false;
        }
        permissions = serviceProvider.getProvider();
        return permissions != null;
    }

    private boolean setupEconomy() {
        if (!ASConfig.USE_ECONOMY) {
            return false;
        }

        RegisteredServiceProvider<Economy> serviceProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (serviceProvider == null) {
            return false;
        }
        economy = serviceProvider.getProvider();
        return true;
    }

    /**
     * Gets the instance of the plugin.
     *
     * @return The plugin's instance.
     */
    public static AdvancedSpawners getInstance() {
        return instance;
    }

    /**
     * Gets the Vault economy API.
     *
     * @return The Vault economy API.
     */
    public static Economy getEconomy() {
        return economy;
    }

    /**
     * Gets the Vault permissions API.
     *
     * @return The Vault permissions API.
     */
    public static Permission getPermissions() {
        return permissions;
    }
}
