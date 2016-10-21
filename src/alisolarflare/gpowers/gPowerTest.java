package alisolarflare.gpowers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gPowerTest implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (!(args.length < 2)){
			player.sendMessage("Proper Usage to test G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		
		return false;
	}

}
