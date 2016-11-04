package alisolarflare.minigames.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.minigames.data.SpawnSet;
import buttondevteam.lib.chat.TBMCCommandBase;

public class SetColourSpawn extends TBMCCommandBase{
	private SpawnSet spawnSet;
	
	public SetColourSpawn(SpawnSet spawnSet){
		this.spawnSet = spawnSet;
	}
	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player))
			sender.sendMessage("ERROR: You must be a player to use this command!");
		
		Player player = (Player) sender;
		
		if(!(player.getName().equalsIgnoreCase("Alisolarflare")))
			player.sendMessage("ERROR: You must be Alisolarflare to use this command!");
		
		
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
		return false;
	}
	@Override
	public String[] GetHelpText(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
