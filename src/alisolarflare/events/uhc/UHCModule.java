package alisolarflare.events.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class UHCModule extends Module {
	public UHCMatch generalMemory;

	public void register(JavaPlugin plugin){
		registerCommands(plugin);
		registerListeners(plugin);
		registerMemoryUnits(plugin);
	}
	private void registerListeners(JavaPlugin plugin) {
	}
	private void registerCommands(JavaPlugin plugin) {
		// TODO Auto-generated method stub
		registerCommand(plugin, "addToUHC", new AddToUHC(this.generalMemory));
	}
	private void registerMemoryUnits(JavaPlugin plugin){
		generalMemory = new UHCMatch();
	}
}
