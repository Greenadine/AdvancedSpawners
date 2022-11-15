package dev.greenadine.advancedspawners.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.greenadine.advancedspawners.util.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("advancedspawners|as|spawners")
@Description("Manage the plugin.")
@CommandPermission(Permissions.COMMAND)
public class AdvancedSpawnersCommand extends BaseCommand {

    @HelpCommand
    public void onHelp(CommandSender sender) {
        // TODO
    }

    @Subcommand("save")
    @Description("Force save spawners data to file.")
    @CommandPermission(Permissions.COMMAND_SAVE)
    public void onSave(CommandSender sender) {
        // TODO
    }

    @Subcommand("reload")
    @Description("Reload the plugin's configuration file.")
    @CommandPermission(Permissions.COMMAND_RELOAD)
    public void onReload(CommandSender sender) {
        // TODO
    }

    @Subcommand("give")
    @Description("Give a spawner to yourself or someone else.")
    @CommandPermission(Permissions.COMMAND_GIVE)
    public void onGive(CommandSender sender) {
        // TODO
    }

    @Subcommand("setlevel")
    @Description("Sets the level of the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_SET_LEVEL)
    public void onSetlevel(Player player) {
        // TODO
    }

    @Subcommand("settype")
    @Description("Sets the type of the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_SET_TYPE)
    public void onSettype(Player player) {
        // TODO
    }

    @Subcommand("enable")
    @Description("Enable the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_ENABLE)
    public void onEnable(Player player) {
        // TODO
    }

    @Subcommand("disable")
    @Description("Disable the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_DISABLE)
    public void onDisable(Player player) {
        // TODO
    }

    @Subcommand("lock")
    @Description("Lock the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_LOCK)
    public void onLock(Player player) {
        // TODO
    }

    @Subcommand("unlock")
    @Description("Unlock the spawner you're currently looking at.")
    @CommandPermission(Permissions.COMMAND_UNLOCK)
    public void onUnlock(Player player) {
        // TODO
    }

    @Subcommand("adminbypass")
    @Description("Toggle admin bypass.")
    @CommandPermission(Permissions.COMMAND_ADMIN_BYPASS)
    public void onAdminbypass(Player player) {
        // TODO
    }
}
