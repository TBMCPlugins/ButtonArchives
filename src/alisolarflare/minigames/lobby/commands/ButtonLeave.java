package alisolarflare.minigames.lobby.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.lobby.LobbyModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class ButtonLeave extends TBMCCommandBase {

	private LobbyModule lobby;

	public ButtonLeave(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		Player player = (Player) sender;
		String name = player.getName();
		if (!(lobby.fighters.contains(name))) {
			player.sendMessage("You are not fighting!");
			return false;
		}
		lobby.fighters.remove(name);
		if (!(lobby.fighters.contains(name))) {
			player.sendMessage("You have left the fighters category!");
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}

}
