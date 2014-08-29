package com.thedreamsanctuary.dreamcatcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.thevoxelbox.voxelguest.modules.asshat.ban.Banlist;
import com.thevoxelbox.voxelguest.utils.UUIDFetcher;

/**
 * Represents a voting session of one individual
 *
 * @author TheCryoknight
 */
public class VoteSession implements Runnable
{
    private int               taskID   = -1;
    private final long        timeStarted;
    private final Player      target, originator;
    private final VoteType    voteType;
    private final Set<Player> votesYes = Collections.synchronizedSet(new HashSet<>());

    public VoteSession(final Player target, final Player originator, final VoteType voteType, final String reason)
    {
        this.target = target;
        this.originator = originator;
        this.voteType = voteType;
        this.timeStarted = System.currentTimeMillis();
    }

    @Override
    public void run()
    {
        if (this.taskID == -1)
        {
            throw new IllegalStateException();
        }
        if (DreamCatcher.getVoteConfig().getMinVotersToAct() <= this.votesYes.size())
        {
            if (DreamCatcher.getVoteConfig().getMinPercentOfVotes() <= ((float) this.votesYes.size() / (Bukkit.getOnlinePlayers().length - 2)))
            // TODO: fix logoff abuse
            {
                Bukkit.broadcastMessage("Vote Passed on " + this.target.getDisplayName());
                switch(this.voteType)
                {
                case BAN:
                    target.kickPlayer("");
                    Bukkit.broadcastMessage(DreamCatcher.getVoteConfig().getKickBanMessage().replaceFirst("%offender%", this.target.getDisplayName()).replaceFirst("%action", "banned").replaceFirst("%voter%", this.originator.getDisplayName()));
                    final UUID playerUUID;
                    try
                    {
                        playerUUID = UUIDFetcher.getUUIDOf(this.target.getName());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        return;
                    }
                    Banlist.ban(playerUUID, "");
                    break;
                case KICK:
                    this.target.kickPlayer("");
                    Bukkit.broadcastMessage(DreamCatcher.getVoteConfig().getKickBanMessage().replaceFirst("%offender%", this.target.getDisplayName()).replaceFirst("%action", "kicked").replaceFirst("%voter%", this.originator.getDisplayName()));
                    break;
                case MUTE:
                    //Unimplemented
                    break;
                default:
                    break;
                }
                Bukkit.getScheduler().cancelTask(this.taskID);
            }
        }
        if (((System.currentTimeMillis() - this.timeStarted) / 60000) == DreamCatcher.getVoteConfig().getMaxVoteTime())
        {
            Bukkit.getScheduler().cancelTask(this.taskID);
        }
    }

    public void voteYes(final Player vote)
    {
        if (!vote.equals(this.originator))
        {
            this.votesYes.add(vote);
        }
    }

    public VoteType getVoteType()
    {
        return this.voteType;
    }

    public Player getTarget()
    {
        return this.target;
    }

    public Player getOriginator()
    {
        return this.originator;
    }

    public void setTaskID(final int taskID)
    {
        this.taskID = taskID;
    }

    public long getTimeStarted()
    {
        return this.timeStarted;
    }

}
