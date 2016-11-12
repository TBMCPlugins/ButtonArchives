package alisolarflare.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.flairdoor.commands.FlairMe;
import alisolarflare.components.flairdoor.listeners.PortalListener;
import alisolarflare.modules.Module;

public class FlairDoorModule extends Module {
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe());
		registerListener(plugin, new PortalListener(plugin));
	}
}
