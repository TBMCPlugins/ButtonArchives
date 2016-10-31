package alisolarflare.magictrick.aliarrow;

import java.util.logging.Level;
import alisolarflare.AliPresents;

public class AliArrowSubPlugin {
	private AliPresents plugin;

	public AliArrowSubPlugin(AliPresents plugin){
		this.plugin = plugin;
	}
	/**
	 * Registers the plugin, activating listeners, commands, and events
	 */
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
