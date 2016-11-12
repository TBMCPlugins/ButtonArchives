package alisolarflare.components.alilinks;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.alilinks.commands.PressAliLink;
import alisolarflare.components.alilinks.commands.SetAliLink;
import alisolarflare.components.alilinks.entities.Link;

public class AliLinkComponent extends Component {
	private SetAliLink setAliLink;

	@Override
	public void register(JavaPlugin plugin) {
		setAliLink = new SetAliLink(plugin);
		
		registerCommand(plugin, new PressAliLink(plugin, setAliLink));
		registerCommand(plugin, setAliLink);

	}

	public void saveLinkList(JavaPlugin plugin) {
		plugin.getConfig().set("aliLinkList", setAliLink.linkList);
	}

	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(JavaPlugin plugin) {
		return (List<Link>) plugin.getConfig().getList("aliLinkList");
	}

}
