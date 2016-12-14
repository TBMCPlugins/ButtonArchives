package buttondevteam.alipresents.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.gpowers.commands.GPower;
import buttondevteam.alipresents.components.gpowers.enchant.EnchantingLoop;
import buttondevteam.alipresents.components.gpowers.powerstate.PowerDown;
import buttondevteam.alipresents.components.gpowers.powerstate.PowerUp;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new GPower());
		registerCommand(plugin, new PowerUp());
		registerCommand(plugin, new PowerDown());

		registerListener(plugin, new EnchantingLoop(plugin));

	}

}
