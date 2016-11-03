package alisolarflare.modules.magictrick.aliarrow;

import org.bukkit.plugin.java.JavaPlugin;
import alisolarflare.modules.Module;
import buttondevteam.lib.TBMCCoreAPI;

public class AliArrowModule extends Module {
	/**
	 * Registers the plugin, activating listeners, commands, and events
	 */
	@Override
	public void register(JavaPlugin plugin) {
		TBMCCoreAPI.RegisterEventsForExceptions(new AliArrowListener(plugin), plugin);

	}
}
