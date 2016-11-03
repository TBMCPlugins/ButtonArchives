package alisolarflare.buttonminigames.freeforall.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.MainPlugin;
import alisolarflare.buttonminigames.freeforall.data.SpawnSet;

public class SetFFAS implements CommandExecutor{
	private MainPlugin plugin;
	private SpawnSet spawnSet;
	
	public SetFFAS(MainPlugin plugin, SpawnSet spawnSet){
		this.plugin = plugin;
		this.spawnSet = spawnSet;
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("ERROR: You must be a Alisolarflare and playing to use this command!");
		}
		Player player = (Player) sender;
		
		if(!(player.equals(plugin.getServer().getPlayer("Alisolarflare")))){
			player.sendMessage("ERROR: You must be Alisolarflare to use this command!");
		}
		
		if(args.length <= 0){
			sender.sendMessage("ERROR: Arguments required.");
			return false;
		}
		
		String input = args[0];
		
		if(input == null){
			sender.sendMessage("ERROR: Arguments are null");
			return false;
		}
		
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
	
}
