package alisolarflare.components.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.minigames.data.SpawnSet;

public class SetColourSpawn extends ModCommand{
	private SpawnSet spawnSet;
	
	public SetColourSpawn(SpawnSet spawnSet){
		this.spawnSet = spawnSet;
	}
	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		Player player = (Player) sender;
		
		if(args.length == 0){
			sender.sendMessage("ERROR: Arguments required.");
			return false;
		}
		
		String input = args[0];
		
		input.toLowerCase();
		switch(input){
		case ("r"):
			sender.sendMessage("Setting Red Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Red Spawn Set!");
			break;
		case ("o"):
			sender.sendMessage("Setting Orange Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Orange Spawn Set!");
			break;
		case ("y"):
			sender.sendMessage("Setting Yellow Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Yellow Spawn Set!");
			break;
		case ("g"):
			sender.sendMessage("Setting Green Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Green Spawn Set!");
			break;
		case ("b"):
			sender.sendMessage("Setting Blue Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Blue Spawn Set!");
			break;
		case ("p"):
			sender.sendMessage("Setting Purple Spawn...");
			spawnSet.setRSpawn(player.getLocation());
			sender.sendMessage("Purple Spawn Set!");
			break;
		}
		return true;
	}
	public String[] GetHelpText(String alias){
		return new String[] {
				"Usage:  /SetColourSpawn <colour>",
				"Colours: red, orange, yellow, green, blue, purple"
		};
	}
}
