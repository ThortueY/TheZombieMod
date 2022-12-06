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
    @Override
    public String getName() {
        return "arena-create";
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
        if (sender instanceof Player) {
            Player player = (Player) sender;

            String arenaName = args[0];

            if (args[0].length() < 1 ) {
                player.sendMessage("[Zombie]: Vous devez spécifier le nom de l'arène]");

            } else {
                player.sendMessage("[Zombie]: l'arène"+args[0]+"a été crée !");
                player.sendMessage("[Zombie]: Veillez à ce que votre arène soit configuré au minimum avant de vous déconnecter ou de relancer le serveur");
                //TODO : Dans le fichier de configuration de l'arène mettre le nom de l'arène.

            }
            


        }

    }
}
