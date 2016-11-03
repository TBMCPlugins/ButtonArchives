package alisolarflare.minigames.lobby.commands;

import java.util.stream.Collectors;

import org.bukkit.command.CommandSender;

import alisolarflare.minigames.lobby.LobbyModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class ListFighters extends TBMCCommandBase {
	private LobbyModule lobby;

	public ListFighters(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		sender.sendMessage(lobby.fighters.stream().map(Object::toString).collect(Collectors.joining(", ")));
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
