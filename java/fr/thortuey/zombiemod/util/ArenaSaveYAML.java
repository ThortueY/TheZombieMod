package fr.thortuey.zombiemod.util;

import fr.thortuey.zombiemod.ZombieMod;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
public class ArenaSaveYAML {
    private final ZombieMod plugin = ZombieMod.getInstance();
    private File configFileArena;
    private YamlConfiguration yamlConfiguration;
    String arenaName;

    final String keyArenaPosition = "arenasPositon";

    public ArenaSaveYAML(ZombieMod pluginInstance) {
    }

    public void createArenaConfig(String arenaName) {
        if (!this.plugin.getDataFolder().exists()) {
            this.plugin.getDataFolder().mkdir();
        }

        File arenaFolder = new File(this.plugin.getDataFolder() + "/arenas");
        arenaFolder.mkdir();
        if (!arenaFolder.exists()) {
            arenaFolder.mkdir();
        }

        File configFileArena = new File(this.plugin.getDataFolder() + "/arenas", arenaName + ".yml");
        if (!configFileArena.exists()) {
            try {
                configFileArena.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            yamlConfiguration.set("arenaName",arenaName);
        }

    }

    public boolean isArenaExist(String arenaName) {
        boolean isExist = false;
        try {
            yamlConfiguration.load(new File(plugin.getDataFolder()+"/arenas/"+arenaName+".yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        if (yamlConfiguration.contains("arenaName")== true) {
            String selectedArena = String.valueOf(yamlConfiguration.get("arenaName"));
            if(selectedArena != arenaName) {
                isExist = false;
            } else {
                isExist = true;
            }
        }

        return isExist;

    }
    public void setArenaPosition1(String arenaName , int posX1, int posY1 , int posZ1) {
        try {
            yamlConfiguration.load(new File(plugin.getDataFolder()+"/arenas/"+arenaName+".yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        if(arenaName != yamlConfiguration.get("arenaName")) {
            System.out.println("[Zombie]: Invalid key arenaName");
        } else {
            yamlConfiguration.set(keyArenaPosition+".PosX1", posX1);
            yamlConfiguration.set(keyArenaPosition+".posY1",posY1);
            yamlConfiguration.set(keyArenaPosition+".posZ1",posZ1);
        }


    }
    public void setArenaPosition2(String arenaName , int posX2, int posY2 , int posZ2) {
        try {
            yamlConfiguration.load(new File(plugin.getDataFolder()+"/arenas/"+arenaName+".yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        if(arenaName != yamlConfiguration.get("arenaName")) {
            System.out.println("[Zombie]: Invalid key arenaName");
        } else {
            yamlConfiguration.set(keyArenaPosition+".PosX2", posX2);
            yamlConfiguration.set(keyArenaPosition+".posY2",posY2);
            yamlConfiguration.set(keyArenaPosition+".posZ2",posZ2);
        }


    }

}
