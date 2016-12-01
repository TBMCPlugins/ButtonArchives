package alisolarflare.components.alilinks;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.alilinks.commands.AliLink;

public class AliLinkComponent extends Component {
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new AliLink(plugin));
	}
}
