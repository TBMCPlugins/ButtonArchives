package alisolarflare.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.MinigameModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class LeaveMinigame extends TBMCCommandBase {

	private MinigameModule lobby;

	public LeaveMinigame(MinigameModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
		}
		
		String name = sender.getName();
		if (!(lobby.fighters.contains(name))) {
			sender.sendMessage("You are not fighting!");
			return false;
		}
		
		while(lobby.fighters.contains(name)){
			lobby.fighters.remove(name);
		}
		sender.sendMessage("You have left the fighters category!");
		
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}

}
