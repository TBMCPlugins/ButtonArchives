package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.gpowers.commands.GPower;
import alisolarflare.components.gpowers.commands.PowerDown;
import alisolarflare.components.gpowers.commands.PowerUp;
import alisolarflare.components.gpowers.listeners.gPowerListener;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		GPowerMemory gPowerMemory = new GPowerMemory();
		registerCommand(plugin, new GPower(gPowerMemory));
		registerCommand(plugin, new PowerUp(gPowerMemory));
		registerCommand(plugin, new PowerDown(gPowerMemory));

		registerListener(plugin, new gPowerListener(plugin, gPowerMemory));

	}

}
