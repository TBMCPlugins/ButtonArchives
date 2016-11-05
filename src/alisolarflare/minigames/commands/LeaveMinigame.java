package alisolarflare.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.MinigameModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class LeaveMinigame extends TBMCCommandBase {

	private MinigameModule module;

	public LeaveMinigame(MinigameModule module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if(!(sender instanceof Player))
			sender.sendMessage("You must be a player to use this command!");
		
		
		String name = sender.getName();
		if (!(module.fighters.contains(name))) {
			sender.sendMessage("You are not fighting!");
			return false;
		}
		
		while(module.fighters.contains(name)){
			module.fighters.remove(name);
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
