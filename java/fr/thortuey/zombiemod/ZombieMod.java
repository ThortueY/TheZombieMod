package fr.thortuey.zombiemod;

import fr.thortuey.zombiemod.commands.Alias;
import fr.thortuey.zombiemod.util.ArenaSaveYAML;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieMod extends JavaPlugin {
    public static Logger log;
    ArenaSaveYAML arenaSaveYAML;

    public ZombieMod() {
    }

    public static ZombieMod getInstance() {
        return (ZombieMod)getPlugin(ZombieMod.class);
    }

    public void createConfig() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        File fileConfig = new File(this.getDataFolder(), "config.yml");
        if (!fileConfig.exists()) {
            try {
                fileConfig.createNewFile();
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        }

    }

    public void setArenaSaveYAML(ArenaSaveYAML arenaSaveYAML) {
        this.arenaSaveYAML = arenaSaveYAML;
    }

    public void onEnable() {
        log = this.getLogger();
        System.out.println("§2§n[Zombie]:§r§a Plugin detected and starting");
        this.getCommand("zombie").setExecutor(new Alias());
        System.out.println("§2§n[Zombie]:§r§4 Loading instances...");
        System.out.println("§2§n[Zombie]:§r§a Loading configuration");
        this.createConfig();

        System.out.println("§2§n[Zombie]:§r§4 Loading arenas ....");
        new ArenaSaveYAML(this);
        super.onEnable();
    }

    public void onDisable() {
        super.onDisable();
    }
}
