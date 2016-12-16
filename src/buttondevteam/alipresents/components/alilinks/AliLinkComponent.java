package buttondevteam.alipresents.components.alilinks;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.alilinks.commands.Press;
import buttondevteam.alipresents.components.alilinks.commands.Set;

public class AliLinkComponent extends Component {
	private static JavaPlugin p;

	public static JavaPlugin getPlugin() {
		return p;
	}

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(p = plugin, new Press());
		registerCommand(plugin, new Set());
	}
}
