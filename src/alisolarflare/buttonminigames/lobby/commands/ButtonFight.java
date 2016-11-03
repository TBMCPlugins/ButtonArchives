package alisolarflare.buttonminigames.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.MainPlugin;

public class ButtonFight implements CommandExecutor{
	private MainPlugin plugin;
	public ButtonFight(MainPlugin initPlugin){
		plugin = initPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("You must be a player to be using this command!");
			return false;
		}


		Player player = (Player) sender;
		player.sendMessage(player.toString());
		
		if(plugin.fighters.contains(player)){
			player.sendMessage("You are already in the button fight!");
			return false;
		}
		
		plugin.fighters.add(player);
		
		if(plugin.fighters.contains(player)){
			player.sendMessage("You have joined the fighters category!");
		}		
		return false;
	}
	
}
