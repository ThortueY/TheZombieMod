package fr.thortuey.zombiemod;

import fr.thortuey.zombiemod.commands.Alias;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ZombieMod extends JavaPlugin {

    public static Logger log;

    @Override
    public void onEnable() {

        ZombieMod.log = getLogger();
        System.out.println("[Zombies]: Plugin detected and starting");

        getCommand("zombie").setExecutor(new Alias());


        super.onEnable();
    }

    public void onDisable() {
        super.onDisable();
    }
}
