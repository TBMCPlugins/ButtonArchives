package alisolarflare.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class Module_FlairDoor extends Module {
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Command_FlairMe());
		registerListener(plugin, new Listener_Portal(plugin));
	}
}
