package alisolarflare.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.uhc.commands.AddToUHC;
import alisolarflare.uhc.commands.ConfigureMatch;
import alisolarflare.uhc.commands.ScheduleMatch;
import alisolarflare.uhc.commands.StartMatch;
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
		
		registerCommand(plugin, new AddToUHC(match));
		registerCommand(plugin, new StartMatch(match));
		registerCommand(plugin, new ConfigureMatch(match));
		registerCommand(plugin, new ScheduleMatch(match));
	}	
}
