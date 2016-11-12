package alisolarflare.modules.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.magic.tricks.AliArrowListener;
import alisolarflare.modules.magic.tricks.BoomBowDeathListener;
import alisolarflare.modules.magic.tricks.BoomBowListener;

public class MagicModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowDeathListener());
		registerListener(plugin, new BoomBowListener(plugin));
	}
}
