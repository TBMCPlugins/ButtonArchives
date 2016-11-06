package alisolarflare.components.flairdoor;

import org.bukkit.command.CommandSender;

import buttondevteam.lib.chat.TBMCCommandBase;

public class Command_FlairMe extends TBMCCommandBase {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		Listener_Portal.playersToBeFlaired.add(sender.getName());
		sender.sendMessage("Setup Successful! Walk through a portal to get your flair");

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
