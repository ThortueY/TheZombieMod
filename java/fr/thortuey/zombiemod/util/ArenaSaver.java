package fr.thortuey.zombiemod.util;

import fr.thortuey.zombiemod.ZombieMod;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ArenaSaver {
    private final ZombieMod plugin = ZombieMod.getInstance();
    private final YamlConfiguration yamlConfiguration = new YamlConfiguration();
    private final String keyArenaPosition = "arenaPosition";
    File arenaDir = new File(this.plugin.getDataFolder() + "/arena");

    public void createArenaConfig(String arenaName) {
        if (!this.plugin.getDataFolder().exists()) {
            if (this.plugin.getDataFolder().mkdir()) throw new RuntimeException("Can't create plugin folder");
        }

        yamlConfiguration.set("arenaName", arenaName);
        try {
            save(arenaName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setArenaPosition1(String arenaName, int posX1, int posY1, int posZ1) {
        try {
            yamlConfiguration.load(new File(arenaDir, arenaName + ".yml"));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        if (!yamlConfiguration.get("arenaName", arenaName).equals(arenaName)) {
            System.out.println("[Zombie]: Invalid key arenaName in Position1");
        } else {
            yamlConfiguration.set(keyArenaPosition + ".PosX1", posX1);
            yamlConfiguration.set(keyArenaPosition + ".posY1", posY1);
            yamlConfiguration.set(keyArenaPosition + ".posZ1", posZ1);

            try {
                save(arenaName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setArenaPosition2(String arenaName, int posX2, int posY2, int posZ2) {
        try {
            yamlConfiguration.load(new File(arenaDir, arenaName + ".yml"));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        if (!yamlConfiguration.get("arenaName", arenaName).equals(arenaName)) {
            System.out.println("[Zombie]: Invalid key arenaName in Position2");
        } else {
            yamlConfiguration.set(keyArenaPosition + ".PosX2", posX2);
            yamlConfiguration.set(keyArenaPosition + ".posY2", posY2);
            yamlConfiguration.set(keyArenaPosition + ".posZ2", posZ2);

            try {
                save(arenaName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save(String arenaName) throws IOException {
        if (!arenaDir.exists()) if (!arenaDir.mkdir()) throw new RuntimeException("Can't create arena directory");

        File config = new File(arenaDir, arenaName + ".yml");
        if (!config.exists()) {
            try {
                if (!config.createNewFile()) throw new RuntimeException("Can't create file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        yamlConfiguration.save(config);
    }
}
