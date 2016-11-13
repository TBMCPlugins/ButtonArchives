package alisolarflare.components.creativeboundaries.commands;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class Cbgm1 extends PlayerCommand {

	List<Player> cbCreatives;

	public Cbgm1(CreativeBoundariesComponent component) {
		this.cbCreatives = component.cbCreatives;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String arg2, String[] arg3) {
		

		Player player = (Player) sender;
		TownBlock tb = TownyUniverse.getTownBlock(player.getLocation());
		
		if (tb == null) {
			player.sendMessage("Some error occured.");
			player.sendMessage("TownBlock is null.");
			return false;
		}
		Town town;
		try {
			town = tb.getTown();
		} catch (NotRegisteredException e) {
			player.sendMessage("You aren't standing in a town, head to your home town to use this command.");
			return false;
		}
		
		boolean playerIsInTown = false;
		for(Resident res : town.getResidents()){
			if (res.getName().toString().equals(player.getName().toString())){
				playerIsInTown = true;
				break;
			}
		}
		if (!playerIsInTown){
			player.sendMessage("Sorry, you're not part of this town");
			return false;
		}
		
		player.setGameMode(GameMode.CREATIVE);
		cbCreatives.add(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage: When in a town that you either own or are a resident of, type /cbgm1 to gain creative"
		};
	}
}
