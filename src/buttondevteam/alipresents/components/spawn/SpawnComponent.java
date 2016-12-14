package buttondevteam.alipresents.components.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.spawn.cows.CowSpawnLoop;

public class SpawnComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new CowSpawnLoop(plugin));
	}

}
