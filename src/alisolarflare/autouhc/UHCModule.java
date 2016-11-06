package alisolarflare.autouhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.autouhc.controller.SetMatchState;
import alisolarflare.autouhc.idle.AddToUHC;
import alisolarflare.autouhc.idle.JoinUHC;
import alisolarflare.autouhc.intro.ConfigureMatch;
import alisolarflare.autouhc.intro.ScheduleMatch;
import alisolarflare.autouhc.intro.StartMatch;
import alisolarflare.autouhc.memory.MatchState;
import alisolarflare.autouhc.memory.UHCMatch;

public class UHCModule extends Module {
	public UHCMatch match;

	public void register(JavaPlugin plugin) {
		
		
		if (plugin.getConfig().contains("UHCMatchState")){
			match = new UHCMatch(plugin.getConfig(), MatchState.valueOf(plugin.getConfig().getString("UHCMatchState")));
		}else{
			match = new UHCMatch(plugin.getConfig(), MatchState.IDLE);
		}
		

		//registerCommand(plugin, new SetMatchState(match));
		//registerCommand(plugin, new AddToUHC(match));
		//registerCommand(plugin, new JoinUHC(match));
		//registerCommand(plugin, new StartMatch(match));
		//registerCommand(plugin, new ConfigureMatch(match));
		//registerCommand(plugin, new ScheduleMatch(match));
		
	}	
}
