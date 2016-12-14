package buttondevteam.alipresents.components.alilinks;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.alilinks.commands.AliLink;

public class AliLinkComponent extends Component {
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliLink(plugin));
	}
}
