package com.thedreamsanctuary.dreamcatcher;

import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.thedreamsanctuary.dreamcatcher.commands.VoteKickCommand;
import com.thedreamsanctuary.dreamcatcher.util.Configuration;

public class DreamCatcher extends JavaPlugin
{
    private VoteKickCommand         voteKickCommand;
    private static final VoteConfig config = new VoteConfig();

    @Override
    public void onEnable()
    {
        try
        {
            Configuration.loadConfiguration(new File("plugins" + File.separator + "DreamCatcher" + File.separator + "Config.properties"), config);
        } catch (final IOException e)
        {
            e.printStackTrace();
        }
        this.voteKickCommand = new VoteKickCommand(this);

        this.getCommand("vtkick").setExecutor(this.voteKickCommand);
    }

    public static VoteConfig getVoteConfig()
    {
        return config;
    }

    @Override
    public void onDisable()
    {

    }

}
