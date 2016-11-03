package alisolarflare.events.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.events.uhc.commands.AddToUHC;
import alisolarflare.events.uhc.commands.StartMatch;
import alisolarflare.events.uhc.memory.MatchState;
import alisolarflare.events.uhc.memory.UHCMatch;

public class UHCModule extends Module {
	public UHCMatch match;

	public void register(JavaPlugin plugin) {
		registerMemoryUnits(plugin);
		registerCommands(plugin);
		registerListeners(plugin);
	}
	private void registerMemoryUnits(JavaPlugin plugin) {
		if (plugin.getConfig().contains("UHCMatchState")){
			match = new UHCMatch(plugin.getConfig(), MatchState.valueOf(plugin.getConfig().getString("UHCMatchState")));
		}else{
			match = new UHCMatch(plugin.getConfig(), MatchState.IDLE);
		}
	}
	private void registerListeners(JavaPlugin plugin) {
	}

	private void registerCommands(JavaPlugin plugin) {
		registerCommand(plugin, new AddToUHC(match));
		registerCommand(plugin, new StartMatch(match));
	}

	
}
