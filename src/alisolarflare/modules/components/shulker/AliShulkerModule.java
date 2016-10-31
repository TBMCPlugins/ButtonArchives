package alisolarflare.modules.components.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.shulker.commands.AliShulker;

public class AliShulkerModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		plugin.getCommand("alishulker").setExecutor(new AliShulker());
	}

}
