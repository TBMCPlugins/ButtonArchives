package alisolarflare.tools.gpowers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gPowerCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("G power activate!");
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (args.length < 2){
			player.sendMessage("Proper Usage to test G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		String colour;
		player.sendMessage("Checking terms...");
		if(args[0].startsWith("r") ||
				args[0].startsWith("o")||
				args[0].startsWith("y")||
				args[0].startsWith("g")||
				args[0].startsWith("b")||
				args[0].startsWith("p")){
			colour = args[0];
		}else{
			player.sendMessage("Term Fail: COLOUR. Proper Usage to test G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		boolean isActive;
		if(args[1].startsWith("t")){
			isActive = true;
		}else if (args[1].startsWith("f")){
			isActive = false;
		}else{
			player.sendMessage("Term Fail: ACTIVE. Proper Usage to test G-Powers:");
			player.sendMessage("/gpowertest [colour=red,orange,yellow,green,blue,purple] [active=true/false]");
			return false;
		}
		player.sendMessage("Terms Vaild!");
		if(isActive){
			gPowerMemory.PowerUpPlayer(player, colour);
		}else{
			gPowerMemory.PowerDownPlayer(player);
		}
		return false;
	}

}
