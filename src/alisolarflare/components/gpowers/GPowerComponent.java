package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.gpowers.commands.GPower;
import alisolarflare.components.gpowers.enchant.Enchanter;
import alisolarflare.components.gpowers.powerstate.PowerDown;
import alisolarflare.components.gpowers.powerstate.PowerUp;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		GPowerMemory gPowerMemory = new GPowerMemory();
		registerCommand(plugin, new GPower(gPowerMemory));
		registerCommand(plugin, new PowerUp(gPowerMemory));
		registerCommand(plugin, new PowerDown(gPowerMemory));

		registerListener(plugin, new Enchanter(plugin, gPowerMemory));

	}

}
