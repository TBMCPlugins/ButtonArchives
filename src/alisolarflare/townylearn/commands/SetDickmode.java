package alisolarflare.townylearn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import alisolarflare.townylearn.MainPlugin;

public class SetDickmode implements CommandExecutor{
	private MainPlugin plugin;

	public SetDickmode(MainPlugin plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.getName().equals("Alisolarflare") || sender.getName().equals("iie")){
			if(args[0] == null){
				sender.sendMessage("You must use True, False, 1, or 0 as arguments!");
				return false;
			}
			if(args[0].equalsIgnoreCase("TRUE") || args[0].equalsIgnoreCase("1")){
				sender.sendMessage("Dickmode has been turned on!");
				plugin.setDickmode(true);
				return true;
			}
			if(args[0].equalsIgnoreCase("FALSE") || args[0].equalsIgnoreCase("0")){
				sender.sendMessage("Dickmode has been turned off!");
				plugin.setDickmode(false);
				return true;
			}
			return false;
		}
		return false;
	}
}
