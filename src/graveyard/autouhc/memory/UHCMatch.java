package graveyard.autouhc.memory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

/**@deprecated*/
public class UHCMatch {
	private FileConfiguration config;	
	private MatchState matchState = MatchState.IDLE;
	private List<String> playerList = new ArrayList<String>();
	
	private Location lobbyLocation;
	private Location spawnLocation;
	
	private World ultraHardcoreWorld;
	
	private int worldBorderMaxRadius;
	private int worldBorderMinRadius;
	public UHCMatch(FileConfiguration fileConfiguration, MatchState state) {
		this.config = fileConfiguration;
		this.matchState = state;
	}
	
	public MatchState getMatchState(){
		return matchState;
	}
	
	public void setMatchState(MatchState newMS){
		matchState = newMS;
		config.set("UHCMatchState", newMS.toString());
		switch(newMS){
		default:
			break;
		}
	}

	public List<String> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<String> playerList) {
		this.playerList = playerList;
	}

	public Location getLobbyLocation() {
		
		return lobbyLocation;
	}

	public void setLobbyLocation(Location lobbyLocation) {
		this.lobbyLocation = lobbyLocation;
	}
	
}
