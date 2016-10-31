package alisolarflare.flairdoors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FlairMe implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("Flairing..." + sender.getName());
		PortalListener.playersToBeFlaired.add(sender.getName());
		sender.sendMessage("Finished Preparation! Walk through a portal to get your flair");
		
		return false;
	}

}
