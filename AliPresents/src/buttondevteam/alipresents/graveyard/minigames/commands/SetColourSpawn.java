package buttondevteam.alipresents.graveyard.minigames.commands;
/*package graveyard.minigames.commands;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import graveyard.minigames.data.SpawnSet;

public class SetColourSpawn extends ModCommand{
	private SpawnSet spawnSet;

	public SetColourSpawn(SpawnSet spawnSet){
		this.spawnSet = spawnSet;
	}
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		if(args.length == 0){
			player.sendMessage("ERROR: Arguments required.");
			return false;
		}

		String input = args[0];

		input.toLowerCase();
		switch(input){
		case ("r"):
			player.sendMessage("Setting Red Spawn...");
			spawnSet.RSpawn = player.getLocation();
			player.sendMessage("Red Spawn Set!");
			break;
		case ("o"):
			player.sendMessage("Setting Orange Spawn...");
			spawnSet.OSpawn = player.getLocation();
			player.sendMessage("Orange Spawn Set!");
			break;
		case ("y"):
			player.sendMessage("Setting Yellow Spawn...");
			spawnSet.YSpawn = player.getLocation();
			player.sendMessage("Yellow Spawn Set!");
			break;
		case ("g"):
			player.sendMessage("Setting Green Spawn...");
			spawnSet.GSpawn = player.getLocation();
			player.sendMessage("Green Spawn Set!");
			break;
		case ("b"):
			player.sendMessage("Setting Blue Spawn...");
			spawnSet.BSpawn = player.getLocation();
			player.sendMessage("Blue Spawn Set!");
			break;
		case ("p"):
			player.sendMessage("Setting Purple Spawn...");
			spawnSet.PSpawn = player.getLocation();
			player.sendMessage("Purple Spawn Set!");
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
*/