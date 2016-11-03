package alisolarflare.minigames.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.lobby.LobbyModule;

public class ButtonFight implements CommandExecutor{
	private LobbyModule lobby;

	public ButtonFight(LobbyModule lobby) {
		this.lobby = lobby;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("You must be a player to be using this command!");
			return false;
		}


		Player player = (Player) sender;
		player.sendMessage(player.toString());
		String name = player.getName();
		if(lobby.fighters.contains(name)){
			player.sendMessage("You are already in the button fight!");
			return false;
		}
		
		lobby.fighters.add(name);
		
		if(lobby.fighters.contains(name)){
			player.sendMessage("You have joined the fighters category!");
		}		
		return false;
	}
	
}
