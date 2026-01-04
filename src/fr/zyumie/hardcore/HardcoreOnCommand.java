package fr.zyumie.hardcore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HardcoreOnCommand implements CommandExecutor {
    private final Main plugin;

    public HardcoreOnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        plugin.getHardcoreConfig().set("hardcore.enabled", true);
        plugin.saveHardcoreConfig();

        sender.sendMessage("§aMode Hardcore activé !");
        return true;
    }
}
