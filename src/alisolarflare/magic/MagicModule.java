package alisolarflare.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class MagicModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowDeathListener());
		registerListener(plugin, new BoomBowListener(plugin));
	}
}
