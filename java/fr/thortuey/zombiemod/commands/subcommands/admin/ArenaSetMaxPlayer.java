package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetMaxPlayer extends AliasSubCommands {
    /** Commande Corrigée **/
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

            if(arenaName.length() > 2 ) {
                int maxPlayers = Integer.parseInt(args[2]);

                if(maxPlayers > 2 ) {
                    //TODO: Vérifier que l'arèene éxiste
                    player.sendMessage("[Zombie]: Le nombre de joueur max pour l'arène "+arenaName+ " a été sauvegardé à "+ maxPlayers);
                    //TODO: Sauvegarder dans la configuration l'arène le nombre de joueurs max
                } else if (maxPlayers < 2 ) {
                    player.sendMessage("[Zombie]: Vous ne pouvez pas mettre un seul joueur maximum");

                }
            } else if(arenaName.length() < 2){
                player.sendMessage("[Zombie]: Vous devez préciser l'arène concerné");
            }
        }


    }
}
