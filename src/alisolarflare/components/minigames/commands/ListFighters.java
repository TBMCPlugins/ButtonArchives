package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameComponent;

public class ListFighters extends PlayerCommand {
	private MinigameComponent lobby;

	public ListFighters(MinigameComponent lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		sender.sendMessage(lobby.fighters.toString());
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: Type /ListFighters to get the list of fighters in the current minigame"
		};
	}
}
