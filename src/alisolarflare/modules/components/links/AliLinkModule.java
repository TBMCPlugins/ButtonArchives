package alisolarflare.modules.components.links;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.links.commands.PressAliLink;
import alisolarflare.modules.components.links.commands.SetAliLink;
import alisolarflare.modules.components.links.entities.Link;
import buttondevteam.lib.chat.TBMCChatAPI;

public class AliLinkModule extends Module {
	private SetAliLink setAliLink;

	@Override
	public void register(JavaPlugin plugin) {
		setAliLink = new SetAliLink(plugin);
		TBMCChatAPI.AddCommands(plugin, PressAliLink.class);

	}

	public void saveLinkList(JavaPlugin plugin) {
		plugin.getConfig().set("aliLinkList", setAliLink.linkList);
	}

	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(JavaPlugin plugin) {
		return (List<Link>) plugin.getConfig().getList("aliLinkList");
	}

}
