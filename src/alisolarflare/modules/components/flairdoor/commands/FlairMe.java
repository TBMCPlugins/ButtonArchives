package alisolarflare.modules.components.flairdoor.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.components.flairdoor.listeners.PortalListener;
import buttondevteam.lib.chat.TBMCCommandBase;

public class FlairMe extends TBMCCommandBase {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		sender.sendMessage("Flairing..." + sender.getName());
		PortalListener.playersToBeFlaired.add(sender.getName());
		sender.sendMessage("Finished Preparation! Walk through a portal to get your flair");

		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return new String[] { "" };
	}

	@Override
	public String GetCommandPath() {
		return "flairme";
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}

}
