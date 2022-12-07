package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ArenaCreate extends AliasSubCommands {
    /** Commande corrigée **/
    @Override
    public String getName() {
        return "arenaCreate";
    }

    @Override
    public String getDescription() {
        return "Create arena to play zombie ";
    }

    @Override
    public String getSyntax() {
        return "/zmb arena-create [name]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
            String arenaName = args[1];
            if (arenaName.length() <= 2 ) {
                sender.sendMessage("[Zombie]: Vous devez spécifier le nom de l'arène]");

            } else {
                sender.sendMessage("[Zombie]: l'arène "+arenaName+" a été crée !");
                sender.sendMessage("[Zombie]: Veillez à ce que votre arène soit configuré au minimum avant de vous déconnecter ou de relancer le serveur");
                //TODO: Dans le fichier de configuration de l'arène mettre le nom de l'arène.

            }

    }
}
