package alisolarflare.components.links;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.links.commands.PressAliLink;
import alisolarflare.components.links.commands.SetAliLink;
import alisolarflare.components.links.entities.Link;
import alisolarflare.modules.Module;

public class AliLinkModule extends Module {
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
