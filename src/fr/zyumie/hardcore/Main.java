package fr.zyumie.hardcore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main extends JavaPlugin {

    private File hardcoreFile;
    private FileConfiguration hardcoreConfig;

    @Override
    public void onEnable() {
        setupExternalConfig();

        getCommand("hardcore-on").setExecutor(new HardcoreOnCommand(this));
        getCommand("hardcore-off").setExecutor(new HardcoreOffCommand(this));
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

        getLogger().info("Hardcore activé.");
    }

    private void setupExternalConfig() {
        // Dossier du plugin principal TomX
        File HardcoreFolder = new File("plugins/Hardcore");
        if (!HardcoreFolder.exists()) HardcoreFolder.mkdirs();

        // Fichier hardcore.yml dans TomX
        hardcoreFile = new File(HardcoreFolder, "hardcore.yml");

        if (!hardcoreFile.exists()) {
            try {
                // Copie du hardcore.yml présent dans ton JAR
                Files.copy(getResource("hardcore.yml"), hardcoreFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        hardcoreConfig = YamlConfiguration.loadConfiguration(hardcoreFile);
    }

    public FileConfiguration getHardcoreConfig() {
        return hardcoreConfig;
    }

    public void saveHardcoreConfig() {
        try {
            hardcoreConfig.save(hardcoreFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Hardcore désactivé.");
    }
}
