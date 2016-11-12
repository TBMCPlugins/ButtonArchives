package alisolarflare.components.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.magic.tricks.AliArrowListener;
import alisolarflare.components.magic.tricks.BoomBowDeathListener;
import alisolarflare.components.magic.tricks.BoomBowListener;

public class MagicComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowDeathListener());
		registerListener(plugin, new BoomBowListener(plugin));
	}
}
