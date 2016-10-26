package alisolarflare.uhc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class UHCMemoryUnit {
	private List<String> matchPlayerUsernames = new ArrayList<String>();
	
	public void addPlayerToMatch(String playername){
		matchPlayerUsernames.add(playername);
	}
	public void addPlayerToMatch(Player player){
		matchPlayerUsernames.add(player.toString());
	}
	public void removePlayerFromMatch(Player player){
		if (matchPlayerUsernames.contains(player)){
			matchPlayerUsernames.remove(player.toString());
		}
	}
	public void removeAllPlayersFromMatch(){
		matchPlayerUsernames.clear();
	}
	public void endMatch(){
		matchPlayerUsernames.clear();
	}
}
