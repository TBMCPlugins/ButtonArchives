package alisolarflare.components.fruit;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;

public class FruitComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new GrassBreakListener());
		
	}

}
