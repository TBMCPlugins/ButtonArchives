package alisolarflare.components.flairdoor.proximitydetector;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;

public class SetProximityLocation extends ModCommand{

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length < 1){
			player.sendMessage("You must enter an argument");
			return false;
		}
		String firstChar = args[0].substring(0, 1);
		
		switch(firstChar){
		case "s":
		case "0":
			PlayerProximityLoop.setStartLocation(player.getLocation());
			return true;
		case "e":
		case "1":
			PlayerProximityLoop.setEndLocation(player.getLocation());
			return true;
		default:
			player.sendMessage("You must provide a vaild argument!");
			return false;
		}
	}
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage: /SetProximityLocation <start/end/0/1>",
			"Use this command to set a proximity space: all players",
			"within this space will become flair-able, and portals will",
			"change their colour state."
		};
	}
}
