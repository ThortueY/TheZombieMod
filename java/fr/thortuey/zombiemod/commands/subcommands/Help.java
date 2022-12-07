package fr.thortuey.zombiemod.commands.subcommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thortuey.zombiemod.commands.AliasSubCommands;

public class Help extends AliasSubCommands {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help players to use olugin";
    }

    @Override
    public String getSyntax() {
        return "/zmb help";
    }
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("[Zombies]: All commands for players");



    }
}
