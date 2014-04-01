package com.thedreamsanctuary.dreamcatcher.commands;

import com.thedreamsanctuary.dreamcatcher.DreamCatcher;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by josephkent on 4/1/14.
 */
public class VoteKickCommand implements CommandExecutor {

    private final HashMap<Player, List<Player>> kickVotes = new HashMap<Player, List<Player>>();

    private final DreamCatcher plugin;

    public VoteKickCommand(DreamCatcher plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("vtkick")){
            if(!(commandSender instanceof Player)){
                commandSender.sendMessage("Player only command.");
                return true;
            }

            if(args.length == 0 || args.length >= 2){
                commandSender.sendMessage("Invalid arguments.");
                return true;
            }

            String offenderName = args[0];
            Player offender = plugin.getServer().getPlayer(offenderName);
            Player voter = (Player) commandSender;

            if(kickVotes.containsKey(offender)){
                List<Player> voters = kickVotes.get(offender);
                voters.add(voter);
                checkForKick(offender, voters);
            }
            else{
                List<Player> voters = new ArrayList<Player>();
                voters.add(voter);
                kickVotes.put(offender, voters);
            }

            Bukkit.broadcastMessage(plugin.getConfig().getString("kick.vote-message")
                    .replace("<offender>", offenderName).replace("<voter>", voter.getDisplayName()));
            return true;
        }
        return false;
    }

    private void checkForKick(Player offender, List<Player> voters){
        if(voters.size() >= plugin.getConfig().getInt("kick.votes-required")){
            offender.kickPlayer(plugin.getConfig().getString("kick.kick-message"));
            kickVotes.remove(offender);
        }
    }

}
