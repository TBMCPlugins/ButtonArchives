package alisolarflare.buttonminigames.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alisolarflare.MainPlugin;

public class ListFighters implements CommandExecutor{
	private MainPlugin plugin;
	public ListFighters(MainPlugin initPlugin){
		plugin = initPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		sender.sendMessage(plugin.fighters.toString());	
		return false;
	}
	
}
