package fr.thortuey.zombiemod.commands;

import fr.thortuey.zombiemod.commands.subcommands.Help;
import fr.thortuey.zombiemod.commands.subcommands.admin.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Alias implements CommandExecutor
{
    private ArrayList<AliasSubCommands> subCommands =new ArrayList<>();

    public String commandExecutor;

    public Alias() {
        /** Player commands **/
        subCommands.add(new Help());
        /** Admin commands **/
        subCommands.add(new ArenaCreate());
        subCommands.add(new ArenaPos());
        subCommands.add(new ArenaSetLobby());
        subCommands.add(new ArenaSetMapSpawn());
        subCommands.add(new ArenaSetMaxPlayer());
        subCommands.add(new ArenaSetBreakableWindow());
        subCommands.add(new ArenaAddBreakableWindow());
    }

    public ArrayList<AliasSubCommands> getSubCommands() {
        return subCommands;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0 ) {
            Help help = new Help();
            help.onCommand(commandSender,strings);
        } else {
            for(int i=0 ; i < this.getSubCommands().size(); i++) {
                if(strings[0].equalsIgnoreCase(this.getSubCommands().get(i).getName())){
                    this.getSubCommands().get(i).onCommand(commandSender,strings);
                }
            }
        }


        return true;
    }
}
