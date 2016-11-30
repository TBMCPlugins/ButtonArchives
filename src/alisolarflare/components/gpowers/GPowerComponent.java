package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.gpowers.commands.GPower;
import alisolarflare.components.gpowers.enchant.EnchantingLoop;
import alisolarflare.components.gpowers.powerstate.PowerDown;
import alisolarflare.components.gpowers.powerstate.PowerUp;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new GPower());
		registerCommand(plugin, new PowerUp());
		registerCommand(plugin, new PowerDown());

		registerListener(plugin, new EnchantingLoop(plugin));

	}

}
