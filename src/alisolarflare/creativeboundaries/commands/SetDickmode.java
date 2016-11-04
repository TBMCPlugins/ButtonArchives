package alisolarflare.creativeboundaries.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.creativeboundaries.CreativeBoundariesModule;
import buttondevteam.lib.chat.TBMCCommandBase;

public class SetDickmode extends TBMCCommandBase{
	private CreativeBoundariesModule plugin;

	public SetDickmode(CreativeBoundariesModule plugin){
		this.plugin = plugin;
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
				plugin.dickmode=(true);
				return true;
			}
			if(args[0].equalsIgnoreCase("FALSE") || args[0].equalsIgnoreCase("0")){
				sender.sendMessage("Dickmode has been turned off!");
				plugin.dickmode=(false);
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

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
}
