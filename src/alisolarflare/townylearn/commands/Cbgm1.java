package alisolarflare.townylearn.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.*;

public class Cbgm1 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}

		Player player = (Player) sender;

		TownBlock tb = TownyUniverse.getTownBlock(player.getLocation());
		if (tb == null) {
			player.sendMessage("§cYou aren't standing in a town or some other error occured.");
			player.sendMessage("§cTownBlock is null.");
			return false;
		}
		Town town;
		try {
			town = tb.getTown();
		} catch (NotRegisteredException e) {
			player.sendMessage("§cYou aren't standing in a town or some other error occured.");
			player.sendMessage("§cTownBlock's town is not registered.");
			return false;
		}
		if (town == null) {
			player.sendMessage("§cERROR: The town you're standing in is Null.");
			return false;
		}
		
		for(Resident res : town.getResidents()){
			if (res.getName().toString().equals(player.getName().toString())){
				player.setGameMode(GameMode.CREATIVE);
				return true;
			}
		}
		player.sendMessage("Sorry, you're not part of this town");
		return false;
	}

}
