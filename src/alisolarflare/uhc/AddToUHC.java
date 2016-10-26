package alisolarflare.uhc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddToUHC implements CommandExecutor{
	private UHCMemoryUnit generalMemory;
	
	public AddToUHC(UHCSubPlugin uhcSubPlugin){
		this.generalMemory = uhcSubPlugin.generalMemory;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (player.getName() != "alisolarflare"){
			sender.sendMessage("You must be Ali to use this command, send her a message to change the permissions");
			return false;
		}
		if (args.length <= 1){
			sender.sendMessage("You must supply at least one playername");
		}
		for (int i = 0; i > args.length; i++){
			generalMemory.addPlayerToMatch(player);
		}
		return false;
	}

}
