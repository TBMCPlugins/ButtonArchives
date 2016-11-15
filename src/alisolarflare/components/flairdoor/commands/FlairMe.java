package alisolarflare.components.flairdoor.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.flairdoor.FlairDoorComponent;

public class FlairMe extends PlayerCommand {

	private FlairDoorComponent component;
	public FlairMe(FlairDoorComponent flairDoorComponent) {
		this.component = flairDoorComponent;
	}
	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		component.playersToBeFlaired.add((Player) sender);
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
