package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameModule;

public class JoinMinigame extends PlayerCommand {
	private MinigameModule module;

	public JoinMinigame(MinigameModule module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		String name = sender.getName();
		if (module.fighters.contains(name)) {
			sender.sendMessage("You are already in the minigame!");
			return false;
		}

		module.fighters.add(name);

		if (module.fighters.contains(name)) {
			sender.sendMessage("You have joined the minigame!");
		}
		return false;
	}
}
