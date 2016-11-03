package alisolarflare.minigames.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.lobby.LobbyModule;

public class ButtonLeave implements CommandExecutor{
	
	
	private LobbyModule lobby;

	public ButtonLeave(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You must be a player to be using this command!");
			return false;
		}
		
		Player player = (Player) sender;
		String name = player.getName();
		if (!(lobby.fighters.contains(name))){
			player.sendMessage("You are not fighting!");
			return false;
		}
		lobby.fighters.remove(name);
		if(!(lobby.fighters.contains(name))){
			player.sendMessage("You have left the fighters category!");
		}
		return false;
	}
	
}
