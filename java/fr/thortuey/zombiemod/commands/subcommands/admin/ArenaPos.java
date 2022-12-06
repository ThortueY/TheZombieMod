package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaPos extends AliasSubCommands {
    @Override
    public String getName() {
        return "setPosition";
    }

    @Override
    public String getDescription() {
        return "Permet d'obtenir les coordonnées de la zone de combat";
    }

    @Override
    public String getSyntax() {
        return "/zmb setPosition [ArenaName] ][Pos1 / Pos2]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            String arenaName = args[2];
            if (arenaName.length() < 2) {
                player.sendMessage("[Zombie]: Vous devez spécifier l'arène");
            } else {

                if (args[2] == "pos1") {
                    int posX1 = (int) player.getLocation().getX();
                    int posY1 = (int) player.getLocation().getY();
                    int posZ1 = (int) player.getLocation().getZ();
                    player.sendMessage("(Zombie]: Position 1 placé à XYZ" + posX1 + posY1 + posZ1 + "pour l'arène" + arenaName);

                    //TODO: Dans le fichier configuration de l'arène transposer les coordonnées X, Y et Z du joueur dans la config dans la case 'Pos1' **
                } else if (args[2] == "pos2") {
                    int posX2 = (int) player.getLocation().getX();
                    int posY2 = (int) player.getLocation().getY();
                    int posZ2 = (int) player.getLocation().getZ();
                    player.sendMessage("(Zombie]: Position 2 placé à XYZ" + posX2 + posY2 + posZ2 + "pour l'arène" + arenaName);
                    //TODO: Dans le fichier configuration d el'arène transposer les coordonnées X, Y et Z du joueur dans la config dans la case 'O
                }
            }
        }


    }
}
