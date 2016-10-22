package alisolarflare.aliarrow;

import java.util.logging.Level;

import alisolarflare.AliPresents;

public class AliArrowSubPlugin {
	private AliPresents plugin;

	public AliArrowSubPlugin(AliPresents plugin){
		this.plugin = plugin;
	}
	public void register(){
		registerEvents();
		registerCommands();
		plugin.getLogger().log(Level.INFO, "Discord Sub Plugin Registered!");
	}
	private void registerEvents(){
		plugin.getServer().getPluginManager().registerEvents(new AliArrowListener(plugin), plugin);
		
	}
	private void registerCommands(){
		
	}
}
