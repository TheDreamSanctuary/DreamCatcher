package com.thedreamsanctuary.dreamcatcher;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VoteSessionHandler
{
    private final DreamCatcher plugin;
    private final Map<Player,VoteSession> currentVote = new HashMap<>();
    
    public VoteSessionHandler(final DreamCatcher plugin)
    {
        this.plugin = plugin;
    }
   
    public void newVote(VoteSession newVote)
    {
        this.currentVote.put(newVote.getTarget(), newVote);
        newVote.setTaskID(Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, newVote, 0, 300));
    }
}
