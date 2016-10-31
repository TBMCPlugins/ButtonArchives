package alisolarflare.modules.magictrick.aliarrow;


import org.bukkit.plugin.java.JavaPlugin;
import alisolarflare.modules.Module;

public class AliArrowModule extends Module{
	/**
	 * Registers the plugin, activating listeners, commands, and events
	 */
	@Override
	public void register(JavaPlugin plugin) {		
		plugin.getServer().getPluginManager().registerEvents(new AliArrowListener(plugin), plugin);
		
	}
}
