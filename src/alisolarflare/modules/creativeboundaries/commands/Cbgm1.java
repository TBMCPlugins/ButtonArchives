package alisolarflare.modules.creativeboundaries.commands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

import alisolarflare.modules.PlayerCommand;
import alisolarflare.modules.creativeboundaries.CreativeBoundariesModule;

public class Cbgm1 extends PlayerCommand {

	private CreativeBoundariesModule module;

	public Cbgm1(CreativeBoundariesModule module) {
		this.module = module;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}

		Player player = (Player) sender;

		TownBlock tb = TownyUniverse.getTownBlock(player.getLocation());
		if (tb == null) {
			player.sendMessage("You aren't standing in a town or some other error occured.");
			player.sendMessage("TownBlock is null.");
			return false;
		}
		Town town;
		try {
			town = tb.getTown();
		} catch (NotRegisteredException e) {
			player.sendMessage("You aren't standing in a town or some other error occured.");
			player.sendMessage("TownBlock's town is not registered.");
			return false;
		}
		if (town == null) {
			player.sendMessage("ERROR: The town you're standing in is Null.");
			return false;
		}
		
		for(Resident res : town.getResidents()){
			if (res.getName().toString().equals(player.getName().toString())){
				player.setGameMode(GameMode.CREATIVE);
				module.cbCreatives.add(player);
				return true;
			}
		}
		player.sendMessage("Sorry, you're not part of this town");
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}
