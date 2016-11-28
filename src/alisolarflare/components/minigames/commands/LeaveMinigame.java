package alisolarflare.components.minigames.commands;

import java.util.List;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.PlayerCommand;
import alisolarflare.components.minigames.MinigameComponent;

public class LeaveMinigame extends PlayerCommand {
	private List<String> fighters;

	public LeaveMinigame(MinigameComponent components) {
		this.fighters = components.fighters;
	}

	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {
		if(!(player instanceof Player))
			player.sendMessage("You must be a player to use this command!");
		
		String name = player.getName();
		if (!(fighters.contains(name))) {
			player.sendMessage("You are not fighting!");
			return true;
		}
		
		while(fighters.contains(name)){
			fighters.remove(name);
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
