package graveyard.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import graveyard.shulker.commands.AliShulker;

/**@deprecated*/
public class AliShulkerModule extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliShulker());
	}

}
