package alisolarflare.components.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.magic.tricks.AliArrowListener;
import alisolarflare.components.magic.tricks.BoomBowDeathListener;
import alisolarflare.components.magic.tricks.BoomBowListener;
import alisolarflare.components.magic.tricks.CannonBowListener;

public class MagicComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new AliArrowListener(plugin));
		registerListener(plugin, new BoomBowDeathListener());
		registerListener(plugin, new BoomBowListener(plugin));
		registerListener(plugin, new CannonBowListener());
	}
}
