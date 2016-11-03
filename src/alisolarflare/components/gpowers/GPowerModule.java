package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.gpowers.commands.GPower;
import alisolarflare.components.gpowers.listeners.gPowerListener;

public class GPowerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new GPower());

		registerListener(plugin, new gPowerListener(plugin));
	}

}
