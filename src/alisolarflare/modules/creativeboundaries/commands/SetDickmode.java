package alisolarflare.modules.creativeboundaries.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.PlayerCommand;
import alisolarflare.modules.creativeboundaries.CreativeBoundariesModule;

public class SetDickmode extends PlayerCommand{
	private CreativeBoundariesModule module;

	public SetDickmode(CreativeBoundariesModule module){
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

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}
