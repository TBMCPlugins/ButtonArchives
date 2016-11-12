package alisolarflare.components.easyuhc.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.easyuhc.EasyUHCComponent;

public class SetUHCLobby extends ModCommand{
	EasyUHCComponent module;
	public SetUHCLobby(EasyUHCComponent easyUHCModule) {
		this.module = easyUHCModule;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		module.lobbyLocation = ((Player) sender).getLocation();
		return false;
	}
	
}
