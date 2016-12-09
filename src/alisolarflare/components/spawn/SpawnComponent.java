package alisolarflare.components.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.spawn.cows.CowSpawnLoop;

public class SpawnComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new CowSpawnLoop(plugin));
	}

}
