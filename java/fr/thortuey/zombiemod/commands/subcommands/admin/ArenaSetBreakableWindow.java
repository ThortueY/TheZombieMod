package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetBreakableWindow extends AliasSubCommands {
    @Override
    public String getName() {
        return "arenaSetBreakableWindow";
    }

    @Override
    public String getDescription() {
        return "Définir les position des fenêtre à zombie";
    }

    @Override
    public String getSyntax() {
        return "/Zmb arenaSetBuyableDoor [arenaName] [positon: 1/2]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player =(Player) sender;
            String arenaName = args[1];

            if(arenaName.length() > 2) {

                int actualPosition = 0;
                if (actualPosition == 0) {
                    int posX1window = (int) player.getLocation().getX();
                    int posY1Window = (int) player.getLocation().getY();
                    int posZ1Window = (int) player.getLocation().getZ();
                    //TODO: Vérifier que l'arène éxiste
                    player.sendMessage("[Zombie]: Position 1 pour la fenêtre définie ! Mettez vous à la position 2 et réexécuter la commande");
                } else if (actualPosition == 1) {
                    int posX2window = (int) player.getLocation().getX();
                    int posY2Window = (int) player.getLocation().getY();
                    int posZ2Window = (int) player.getLocation().getZ();
                    player.sendMessage("[Zombie]: Super ! Vous avez définie votre fenêtre");
                    //TODO: sauvegarder dans la configuration de l'arène les coordonnées de la fenêtre en lui donnant automatiquement un nom

                }
            }

        } else {
            sender.sendMessage("[Zombie]: Vous devez être un joueur pour effectuer cette action");
        }

    }
}
