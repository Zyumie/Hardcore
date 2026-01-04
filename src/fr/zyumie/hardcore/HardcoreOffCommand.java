package fr.zyumie.hardcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HardcoreOffCommand implements CommandExecutor {
    private final Main plugin;

    public HardcoreOffCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        plugin.getHardcoreConfig().set("hardcore.enabled", false);
        plugin.saveHardcoreConfig();

        sender.sendMessage("§cMode Hardcore désactivé !");
        return true;
    }
}
