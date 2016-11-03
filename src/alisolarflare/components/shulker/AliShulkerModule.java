package alisolarflare.components.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.shulker.commands.AliShulker;

public class AliShulkerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliShulker());
	}

}
