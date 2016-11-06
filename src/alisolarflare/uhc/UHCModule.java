package alisolarflare.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.uhc.controller.SetMatchState;
import alisolarflare.uhc.idle.AddToUHC;
import alisolarflare.uhc.idle.JoinUHC;
import alisolarflare.uhc.intro.ConfigureMatch;
import alisolarflare.uhc.intro.ScheduleMatch;
import alisolarflare.uhc.intro.StartMatch;
import alisolarflare.uhc.memory.MatchState;
import alisolarflare.uhc.memory.UHCMatch;

public class UHCModule extends Module {
	public UHCMatch match;

	public void register(JavaPlugin plugin) {
		
		
		if (plugin.getConfig().contains("UHCMatchState")){
			match = new UHCMatch(plugin.getConfig(), MatchState.valueOf(plugin.getConfig().getString("UHCMatchState")));
		}else{
			match = new UHCMatch(plugin.getConfig(), MatchState.IDLE);
		}
		

		registerCommand(plugin, new SetMatchState(match));
		registerCommand(plugin, new AddToUHC(match));
		registerCommand(plugin, new JoinUHC(match));
		registerCommand(plugin, new StartMatch(match));
		registerCommand(plugin, new ConfigureMatch(match));
		registerCommand(plugin, new ScheduleMatch(match));
		
	}	
}
