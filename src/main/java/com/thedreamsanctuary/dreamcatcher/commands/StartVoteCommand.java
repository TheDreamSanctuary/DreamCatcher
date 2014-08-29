package com.thedreamsanctuary.dreamcatcher.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.thedreamsanctuary.dreamcatcher.DreamCatcher;

public class StartVoteCommand implements CommandExecutor
{
    public StartVoteCommand(final DreamCatcher dreamCatcher)
    {
        
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args)
    {
        return true;
    }

}
