package com.thedreamsanctuary.dreamcatcher;

import com.thedreamsanctuary.dreamcatcher.util.ConfigurationGetter;
import com.thedreamsanctuary.dreamcatcher.util.ConfigurationSetter;

public class VoteConfig
{
	private int minVotersToAct;
	private int maxVoteTime; // in minutes
	private double minPercentOfVotes;
	private boolean allowOverridePermNode = true;
	private boolean allowBan = true;
	private boolean allowKick = true;
	private boolean allowMute = true;
	private String kickBanMessage = "%offender% has been voted to be %action% by %voter%";
	private String defaultKickMessage = "Asshat";
	
	@ConfigurationGetter("Min-Votes-To-Act")
	public int getMinVotersToAct() {
		return minVotersToAct;
	}
	
	@ConfigurationSetter("Min-Votes-To-Act")
	public void setMinVotersToAct(int minVotersToAct) {
		this.minVotersToAct = minVotersToAct;
	}
	
	@ConfigurationGetter("Min-Percent-Of-Votes-To-Act")
	public double getMinPercentOfVotes() {
		return minPercentOfVotes;
	}
	
	@ConfigurationSetter("Min-Percent-Of-Votes-To-Act")
	public void setMinPercentOfVotes(double minPercentOfVotes) {
		this.minPercentOfVotes = minPercentOfVotes;
	}
	
	@ConfigurationGetter("Max-Vote-Time")
	public int getMaxVoteTime() {
		return maxVoteTime;
	}

	@ConfigurationSetter("Max-Vote-Time")
	public void setMaxVoteTime(int maxVoteTime) {
		this.maxVoteTime = maxVoteTime;
	}
	
	@ConfigurationGetter("Kick-Ban-Message")
	public String getKickBanMessage() {
		return kickBanMessage;
	}
	
	@ConfigurationSetter("Kick-Ban-Message")
	public void setKickBanMessage(String kickBanMessage) {
		this.kickBanMessage = kickBanMessage;
	}
	
	@ConfigurationGetter("Kick-Ban-Message")
	public String getDefaultKickMessage() {
		return defaultKickMessage;
	}
	public void setDefaultKickMessage(String defaultKickMessage) {
		this.defaultKickMessage = defaultKickMessage;
	}
	
	@ConfigurationGetter("Allow-Override-Permnode")
	public boolean isAllowOverridePermNode() {
		return allowOverridePermNode;
	}
	public void setAllowOverridePermNode(boolean allowOverridePermNode) {
		this.allowOverridePermNode = allowOverridePermNode;
	}
	
	@ConfigurationGetter("Allow-Ban")
	public boolean isAllowBan() {
		return allowBan;
	}
	public void setAllowBan(boolean allowBan) {
		this.allowBan = allowBan;
	}
	
	@ConfigurationGetter("Allow-Kick")
	public boolean isAllowKick() {
		return allowKick;
	}
	public void setAllowKick(boolean allowKick) {
		this.allowKick = allowKick;
	}

	@ConfigurationGetter("Allow-Mute")
	public boolean isAllowMute() {
		return allowMute;
	}
	public void setAllowMute(boolean allowMute) {
		this.allowMute = allowMute;
	}
}
