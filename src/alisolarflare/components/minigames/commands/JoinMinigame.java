package alisolarflare.components.minigames.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameComponent;

public class JoinMinigame extends PlayerCommand {
	private MinigameComponent module;

	public JoinMinigame(MinigameComponent module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(Player player, String arg2, String[] arg3) {		
		String name = player.getName();
		if (module.fighters.contains(name)) {
			player.sendMessage("You are already in the minigame!");
			return true;
		}

		module.fighters.add(name);

		if (module.fighters.contains(name)) {
			player.sendMessage("You have joined the minigame!");
		}
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /JoinMinigame to join a current button minigame!"
		};
	}
}
