package buttondevteam.alipresents.components.fruit;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;

public class FruitComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new GrassBreakListener());
		
	}

}
