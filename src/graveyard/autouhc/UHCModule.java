package graveyard.autouhc;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import graveyard.autouhc.memory.MatchState;
import graveyard.autouhc.memory.UHCMatch;

/**@deprecated*/
public class UHCModule extends Component {
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
