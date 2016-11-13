package alisolarflare.components.flairdoor.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.flairdoor.listeners.PortalListener;

public class FlairMe extends PlayerCommand {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		PortalListener.playersToBeFlaired.add((Player) sender);
		sender.sendMessage("Setup Successful! Walk through a portal to get your flair");
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: Type /flairme and enter a portal with coloured",
			"wool underneath to change your flair"
		};
	}
}
