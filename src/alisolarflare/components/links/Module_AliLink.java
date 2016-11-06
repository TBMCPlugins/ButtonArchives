package alisolarflare.components.links;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class Module_AliLink extends Module {
	private Command_SetAliLink setAliLink;

	@Override
	public void register(JavaPlugin plugin) {
		setAliLink = new Command_SetAliLink(plugin);
		
		registerCommand(plugin, new Command_PressAliLink(plugin, setAliLink));
		registerCommand(plugin, setAliLink);

	}

	public void saveLinkList(JavaPlugin plugin) {
		plugin.getConfig().set("aliLinkList", setAliLink.linkList);
	}

	@SuppressWarnings("unchecked")
	public List<Memory_Link> loadLinkList(JavaPlugin plugin) {
		return (List<Memory_Link>) plugin.getConfig().getList("aliLinkList");
	}

}
