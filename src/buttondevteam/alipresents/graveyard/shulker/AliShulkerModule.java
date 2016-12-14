package buttondevteam.alipresents.graveyard.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.graveyard.shulker.commands.AliShulker;

/**@deprecated*/
public class AliShulkerModule extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliShulker());
	}

}
