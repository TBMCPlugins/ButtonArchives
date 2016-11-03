package alisolarflare.townylearn.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cbgm0 implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		player.setGameMode(GameMode.SURVIVAL);
		return false;
	}

}
