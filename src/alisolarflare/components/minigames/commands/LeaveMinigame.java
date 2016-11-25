package alisolarflare.components.minigames.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameComponent;

public class LeaveMinigame extends PlayerCommand {

	private MinigameComponent module;

	public LeaveMinigame(MinigameComponent module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		if(!(player instanceof Player))
			player.sendMessage("You must be a player to use this command!");
		
		
		String name = player.getName();
		if (!(module.fighters.contains(name))) {
			player.sendMessage("You are not fighting!");
			return true;
		}
		
		while(module.fighters.contains(name)){
			module.fighters.remove(name);
		}
		player.sendMessage("You have left the fighters category!");
		
		return true;
	}
	@Override 
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /LeaveMinigame to leave the current minigame!"
		};
	}
}
