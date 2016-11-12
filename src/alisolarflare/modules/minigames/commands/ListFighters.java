package alisolarflare.modules.minigames.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.PlayerCommand;
import alisolarflare.modules.minigames.MinigameModule;

public class ListFighters extends PlayerCommand {
	private MinigameModule lobby;

	public ListFighters(MinigameModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		sender.sendMessage(lobby.fighters.toString());
		return false;
	}
}
