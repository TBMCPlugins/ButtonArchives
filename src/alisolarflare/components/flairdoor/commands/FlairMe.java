package alisolarflare.components.flairdoor.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.flairdoor.listeners.PortalListener;
import alisolarflare.modules.PlayerCommand;

public class FlairMe extends PlayerCommand {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		PortalListener.playersToBeFlaired.add(sender.getName());
		sender.sendMessage("Setup Successful! Walk through a portal to get your flair");

		return false;
	}

	@Override
	public String GetCommandPath() {
		return "flairme";
	}
}
