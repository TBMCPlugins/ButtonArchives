package alisolarflare.modules.events.uhc.memory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Class that contains the data for a single UltraHardcore Match,
 * which represents a single game. 
 * @author Alisolarflare
 */
public class UHCMatch {
	public List<String> playerList = new ArrayList<String>();	
	private MatchState matchState = MatchState.IDLE;
	private FileConfiguration fileConfiguration;
	
	/**Class that fucks shit up*/
	public UHCMatch(FileConfiguration fileConfiguration, String stateName) {
		this.fileConfiguration = fileConfiguration;
		this.matchState = MatchState.valueOf(stateName);
	}
	
	/**Other class that doesn't fuck shit up*/
	public MatchState getMatchState(){
		return matchState;
	}
	
	/**Other class that REALLY fucks shit up*/
	public void setMatchState(MatchState newMS){
		matchState = newMS;
		fileConfiguration.set("UHCMatchState", newMS.toString());
	}
}
