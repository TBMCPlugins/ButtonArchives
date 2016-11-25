package alisolarflare.components.easyuhc.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.easyuhc.EasyUHCComponent;

public class SetUHCLobby extends ModCommand{
	EasyUHCComponent module;
	public SetUHCLobby(EasyUHCComponent easyUHCModule) {
		this.module = easyUHCModule;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		module.lobbyLocation = player.getLocation();
		return false;
	}
	
}
