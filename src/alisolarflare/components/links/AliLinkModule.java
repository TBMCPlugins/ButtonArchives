package alisolarflare.components.links;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.links.commands.PressAliLink;
import alisolarflare.components.links.commands.SetAliLink;
import alisolarflare.components.links.entities.Link;
import buttondevteam.lib.chat.TBMCChatAPI;

public class AliLinkModule extends Module {
	private SetAliLink setAliLink;

	@Override
	public void register(JavaPlugin plugin) {
		setAliLink = new SetAliLink(plugin);
		TBMCChatAPI.AddCommand(plugin, new PressAliLink(plugin, setAliLink));
		TBMCChatAPI.AddCommand(plugin, setAliLink);

	}

	public void saveLinkList(JavaPlugin plugin) {
		plugin.getConfig().set("aliLinkList", setAliLink.linkList);
	}

	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(JavaPlugin plugin) {
		return (List<Link>) plugin.getConfig().getList("aliLinkList");
	}

}
