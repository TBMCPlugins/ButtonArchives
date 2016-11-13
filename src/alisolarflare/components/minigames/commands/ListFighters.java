package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.minigames.MinigameModule;

public class ListFighters extends PlayerCommand {
	private MinigameModule lobby;

	public ListFighters(MinigameModule lobby) {
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
