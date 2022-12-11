package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.ZombieMod;
import fr.thortuey.zombiemod.commands.AliasSubCommands;
import fr.thortuey.zombiemod.util.ArenaSaver;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ArenaCreate extends AliasSubCommands {
    ZombieMod plugin = (ZombieMod)JavaPlugin.getPlugin(ZombieMod.class);
    ArenaSaver arena;

    public ArenaCreate() {
    }

    public String getName() {
        return "arenaCreate";
    }

    public String getDescription() {
        return "Create arena to play zombie ";
    }

    public String getSyntax() {
        return "/zmb arena-create [name]";
    }

    public void onCommand(CommandSender sender, String[] args) {
        String arenaName = args[1];
        if (arenaName.length() <= 2) {
            sender.sendMessage("[Zombie]: Vous devez spécifier le nom de l'arène]");
        } else {
            sender.sendMessage("[Zombie]: l'arène " + arenaName + " a été crée !");
            sender.sendMessage("[Zombie]: Veillez à ce que votre arène soit configuré au minimum avant de vous déconnecter ou de relancer le serveur");
            new ArenaSaver().createArenaConfig(arenaName);
        }

    }
}
