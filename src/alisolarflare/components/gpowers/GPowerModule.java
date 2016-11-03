package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.gpowers.commands.gPowerCommand;
import alisolarflare.components.gpowers.listeners.gPowerListener;
import buttondevteam.lib.TBMCCoreAPI;

public class GPowerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new gPowerCommand());

		TBMCCoreAPI.RegisterEventsForExceptions(new gPowerListener(plugin), plugin);
	}

}
