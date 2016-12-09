package alisolarflare.components.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

public class CreativeBoundariesAPI {
	private static List<Player> cbCreatives = new ArrayList<Player>();
	private static boolean forceBoundaries = false;
	public CreativeBoundariesAPI(List<Player> cbCreatives){
		CreativeBoundariesAPI.cbCreatives = cbCreatives;
	}
	public static void toSurvival(Player player){
		player.setGameMode(GameMode.SURVIVAL);
		cbCreatives.remove(player);
	}
	public static boolean toCreative(Player player){
		if (player.getWorld().getName().equalsIgnoreCase("World")){
			player.sendMessage("Creative Boundaries is disabled on the New Map!");
			return true;
		}
		
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
	public static void setForceBoundaries(boolean forceBoundaries){
		CreativeBoundariesAPI.forceBoundaries = forceBoundaries;
	}
	public static boolean setForceBoundaries(Player player, String[] args){
		if(args.length < 1){
			player.sendMessage("You must use True, False, 1, or 0 as arguments!");
			return false;
		}
		String firstArgument = args[0];
		if(firstArgument.startsWith("t") || firstArgument.equals("1")){
			player.sendMessage("Dickmode has been turned on!");
			forceBoundaries = true;
			return true;
		}
		if(firstArgument.startsWith("f") || firstArgument.equals("0")){
			player.sendMessage("Dickmode has been turned off!");
			forceBoundaries = false;
			return true;
		}
		return false;
	}
	public static boolean getforceBoundaries(){
		return forceBoundaries;
	}
	public static boolean isCBCreative(Player player){
		return cbCreatives.contains(player);
	}
}
