package fr.thortuey.zombiemod.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AliasSubCommands {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void onCommand(CommandSender sender, String[] args);

}
