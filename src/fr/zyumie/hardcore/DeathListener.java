package fr.zyumie.hardcore;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.BanList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {

    private final Main plugin;

    public DeathListener(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (!plugin.getHardcoreConfig().getBoolean("hardcore.enabled")) return;
        if (!plugin.getHardcoreConfig().getBoolean("hardcore.ban-on-death")) return;

        Player player = event.getEntity();

        String banReason = plugin.getHardcoreConfig().getString(
                "messages.ban-reason",
                "Mort en mode hardcore"
        );

        String kickMessage = plugin.getHardcoreConfig().getString(
                "messages.kick-message",
                banReason
        );

        Bukkit.getBanList(BanList.Type.NAME).addBan(
                player.getName(),
                banReason,
                null,
                "Hardcore-On"
        );

        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> player.kickPlayer(kickMessage),
                1L
        );
    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {

        if (!plugin.getHardcoreConfig().getBoolean("hardcore.enabled", true)) return;

        boolean spec = plugin.getHardcoreConfig().getBoolean("hardcore.spectator-on-death", true);
        if (spec) {
            Bukkit.getScheduler().runTaskLater(
                    plugin,
                    () -> event.getPlayer().setGameMode(GameMode.SPECTATOR),
                    2L
            );
        }
    }
}
