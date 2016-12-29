package buttondevteam.alipresents.components.gpower;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.gpower.commands.Test;
import buttondevteam.alipresents.components.gpower.enchant.EnchantingLoop;
import buttondevteam.alipresents.components.gpower.powerstate.PowerDown;
import buttondevteam.alipresents.components.gpower.powerstate.PowerUp;

public class GPowerComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Test());
		registerCommand(plugin, new PowerUp());
		registerCommand(plugin, new PowerDown());
		
		registerCommand(plugin, new ApplyPowerUp());
		registerCommand(plugin, new ApplyPowerDown());
		registerListener(plugin, new EnchantingLoop(plugin));

	}

}
