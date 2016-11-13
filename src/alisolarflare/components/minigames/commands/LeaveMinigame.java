package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameModule;

public class LeaveMinigame extends PlayerCommand {

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
			return true;
		}
		
		while(module.fighters.contains(name)){
			module.fighters.remove(name);
		}
		sender.sendMessage("You have left the fighters category!");
		
		return true;
	}
	@Override 
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /LeaveMinigame to leave the current minigame!"
		};
	}
}
