package alisolarflare.uhc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

/**
 * Class that contains the data for a single UltraHardcore Match,
 * which represents a single game. 
 * @author Alisolarflare
 */
public class UHCMatch {
	private List<String> matchPlayerUsernames = new ArrayList<String>();
	
	/**
	 * Adds a player to an Ultrahardcore match, storing their name
	 * @param playername	player.getName();
	 */
	public void addPlayerToMatch(String playername){
		if (!(matchPlayerUsernames.contains(playername))){
			matchPlayerUsernames.add(playername);
		}
	}
	/**
	 * Adds a player to an Ultrahardcore match, storing their name
	 * @param player		Player to be added
	 */
	public void addPlayerToMatch(Player player){
		if (!(matchPlayerUsernames.contains(player.getName()))){
			matchPlayerUsernames.add(player.getName());
		}
	}
	/**
	 * Removes a player from an Ultrahardcore match, removing their username from the list
	 * @param player
	 */
	public void removePlayerFromMatch(Player player){
		if (matchPlayerUsernames.contains(player)){
			matchPlayerUsernames.remove(player.getName());
		}
	}
	
	/**
	 * Removes all players from the match
	 */
	public void removeAllPlayersFromMatch(){
		matchPlayerUsernames.clear();
	}
	/**
	 * Fully de-loads and clears out this match, reverting all values to the initialized setting
	 */
	public void endMatch(){
		matchPlayerUsernames.clear();
	}
}
