package fr.thortuey.zombiemod.commands.subcommands.admin;

import fr.thortuey.zombiemod.commands.AliasSubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaSetMapSpawn extends AliasSubCommands {
    /** Programme corrigé **/
    @Override
    public String getName() {
        return "arenaSetMapSpawn";
    }

    @Override
    public String getDescription() {
        return "Met le point de spawn de la map de l'arène";
    }

    @Override
    public String getSyntax() {
        return "/zmb arenaSetMapSpawn [arenaName]";
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player =(Player) sender;
            String arenaName = args[1];
            if(arenaName.length() > 2) {
                int posXMapSpawn = (int) player.getLocation().getX();
                int posYMapSpawn = (int) player.getLocation().getY();
                int posZMapSpawn = (int) player.getLocation().getZ();
                float yawMapSpawn = (float) player.getLocation().getYaw();
                float pitchMapSpawn =(float) player.getLocation().getPitch();
                //TODO: Vérifier que l'arèene éxiste
                player.sendMessage("[Zombie]: Le point de spawn du Lobby de l'arène"+arenaName+"a été placé aux coordonnées XYZ Pitch Yaw"+posXMapSpawn+" "+posYMapSpawn+" "+posZMapSpawn+" "+pitchMapSpawn+" "+yawMapSpawn);
                //TODO : Dans le fichier de configuration de l'arène sauvegarder les coordonnées du spawn de la map X Y Z Pitch et Yaw.

            } else if (arenaName.length() < 2){
                player.sendMessage("[Zbomie]: Vous devez spécifier le nom de l'arène");

            }
        } else {
            sender.sendMessage("[Zombie]: Vous devez être un joueur pour exécuter cette commande");
        }

    }
}
