package alisolarflare.minigames.lobby.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.lobby.LobbyModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class ButtonFight extends TBMCCommandBase {
	private LobbyModule lobby;

	public ButtonFight(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {

		Player player = (Player) sender;
		player.sendMessage(player.toString());
		String name = player.getName();
		if (lobby.fighters.contains(name)) {
			player.sendMessage("You are already in the button fight!");
			return false;
		}

		lobby.fighters.add(name);

		if (lobby.fighters.contains(name)) {
			player.sendMessage("You have joined the fighters category!");
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
