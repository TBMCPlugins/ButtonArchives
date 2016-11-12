package alisolarflare.components.creativeboundaries.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class SetDickmode extends PlayerCommand{
	private CreativeBoundariesComponent module;

	public SetDickmode(CreativeBoundariesComponent module){
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (sender.getName().equals("Alisolarflare") || sender.getName().equals("iie")){
			if(args[0] == null){
				sender.sendMessage("You must use True, False, 1, or 0 as arguments!");
				return false;
			}
			if(args[0].equalsIgnoreCase("TRUE") || args[0].equalsIgnoreCase("1")){
				sender.sendMessage("Dickmode has been turned on!");
				module.dickmode=(true);
				return true;
			}
			if(args[0].equalsIgnoreCase("FALSE") || args[0].equalsIgnoreCase("0")){
				sender.sendMessage("Dickmode has been turned off!");
				module.dickmode=(false);
				return true;
			}
			return false;
		}
		return false;
	}
}
