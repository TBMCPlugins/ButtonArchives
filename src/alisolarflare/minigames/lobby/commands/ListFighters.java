package alisolarflare.minigames.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alisolarflare.minigames.lobby.LobbyModule;

public class ListFighters implements CommandExecutor{
	private LobbyModule lobby;

	public ListFighters(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		sender.sendMessage(lobby.fighters.toString());	
		return false;
	}
	
}
