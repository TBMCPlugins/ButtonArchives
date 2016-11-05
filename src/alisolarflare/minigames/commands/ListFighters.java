package alisolarflare.minigames.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.minigames.MinigameModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class ListFighters extends TBMCCommandBase {
	private MinigameModule lobby;

	public ListFighters(MinigameModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		sender.sendMessage(lobby.fighters.toString());
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean GetPlayerOnly() {
		return false;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}

}
