package alisolarflare.uhc.memory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;


public class UHCMatch {
	public List<String> playerList = new ArrayList<String>();	
	private MatchState matchState = MatchState.IDLE;
	private FileConfiguration fileConfiguration;
	
	public UHCMatch(FileConfiguration fileConfiguration, MatchState state) {
		this.fileConfiguration = fileConfiguration;
		this.matchState = state;
	}
	
	public MatchState getMatchState(){
		return matchState;
	}
	
	public void setMatchState(MatchState newMS){
		matchState = newMS;
		fileConfiguration.set("UHCMatchState", newMS.toString());
		switch(newMS){
		default:
			break;
		}
	}
	
}
