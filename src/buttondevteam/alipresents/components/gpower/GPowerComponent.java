package buttondevteam.alipresents.components.gpower;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.gpower.commands.GPower;
import buttondevteam.alipresents.components.gpower.enchant.EnchantingLoop;
import buttondevteam.alipresents.components.gpower.powerstate.PowerDown;
import buttondevteam.alipresents.components.gpower.powerstate.PowerUp;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new GPower());
		registerCommand(plugin, new PowerUp());
		registerCommand(plugin, new PowerDown());

		registerListener(plugin, new EnchantingLoop(plugin));

	}

}
