package com.thedreamsanctuary.dreamcatcher;

import com.thedreamsanctuary.dreamcatcher.commands.VoteKickCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by josephkent on 3/31/14.
 */
public class DreamCatcher extends JavaPlugin {

    private VoteKickCommand voteKickCommand;

    public void onEnable(){
        this.voteKickCommand = new VoteKickCommand(this);

        getCommand("vtkick").setExecutor(voteKickCommand);
    }

    public void onDisable(){

    }

}
