package alisolarflare.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.magic.aliarrow.AliArrowListener;
import alisolarflare.magic.boombow.BoomBowListener;

public class MagicModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowListener());
		
	}

}
