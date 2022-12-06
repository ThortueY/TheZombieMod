package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetMaxPlayer extends AliasSubCommands {
    @Override
    public String getName() {
        return "arenaSetMaxPlayers";
    }

    @Override
    public String getDescription() {
        return "Défnie le nombre maximal de joueurs dans l'arène";
    }

    @Override
    public String getSyntax() {
        return "/zmb arenaSetMaxPlayers [arena] [maxPlayers]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            String arenaName = args[1];
            int maxPlayers = Integer.parseInt(args[2]);

            if(arenaName.length() < 1 ) {
                player.sendMessage("[Zombie]: Vous devez préciser l'arène concerné");
            } else {
                if(maxPlayers < 2 ) {
                    player.sendMessage("[Zombie]: Vous ne pouvez pas mettre un seul joueur maximum");
                }
            }
        }


    }
}
