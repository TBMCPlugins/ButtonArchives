package alisolarflare.uhc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class UHCMemoryUnit {
	private List<Player> matchPlayers = new ArrayList<Player>();
	
	public void addPlayerToMatch(Player player){
		matchPlayers.add(player);
	}
	public void removePlayerFromMatch(Player player){
		if (matchPlayers.contains(player)){
			matchPlayers.remove(player);
		}
	}
	public void removeAllPlayersFromMatch(){
		matchPlayers.clear();
	}
	public void endMatch(){
		matchPlayers.clear();
	}
}
