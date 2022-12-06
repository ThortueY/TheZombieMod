package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetLobby extends AliasSubCommands {
    @Override
    public String getName() {
        return "arenaSetLobby";
    }

    @Override
    public String getDescription() {
        return "Permet de placer le lobby de la map";
    }

    @Override
    public String getSyntax() {
        return "/zmb arenaSetLobby [ArenaName]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            String arenaName = args[1];
            Player player =(Player) sender;
            if(arenaName.length() <2) {

                int posXSpawn = (int) player.getLocation().getX();
                int posYSpawn = (int) player.getLocation().getY();
                int posZSpawn = (int) player.getLocation().getZ();
                float yawSpawn = (float) player.getLocation().getYaw();
                float pitchSpawn = (float) player.getLocation().getPitch();

                player.sendMessage("[Zombie]: Le point de spawn du Lobby de l'arène"+arenaName+"a été placé aux coordonnées XYZ Pitch Yaw"+posXSpawn+posYSpawn+posZSpawn+pitchSpawn+yawSpawn);

                //TODO: Sauvegarder dans le fichier de configuration de l'arène les coordonnées X Y Z Yaw et Pitch du Lobby

            } else {
                player.sendMessage("[Zbomie]: Vous devez spécifier le nom de l'arène");
            }



        } else {
            sender.sendMessage("[Zombie]: Vous devez être un joueur pour exécuter cette commande");

        }

    }
}
