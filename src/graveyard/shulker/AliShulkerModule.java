package graveyard.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import graveyard.shulker.commands.AliShulker;

/**@deprecated*/
public class AliShulkerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliShulker());
	}

}
