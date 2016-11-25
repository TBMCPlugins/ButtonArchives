package alisolarflare.components.alilinks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.alilinks.commands.PressAliLink;
import alisolarflare.components.alilinks.commands.SetAliLink;
import alisolarflare.components.alilinks.entities.Link;

public class AliLinkComponent extends Component {

	private List<Link> linkList;
	private List<Map<String,String>> linkData;
	@Override
	public void register(JavaPlugin plugin) {
		this.linkList = MapToLinkList(plugin.getConfig().getMapList("aliLinkList"), plugin.getServer());
		for (Link link: linkList){
			linkData.add(link.toMap());
		}
		
		registerCommand(plugin, new PressAliLink(plugin, linkList));
		registerCommand(plugin, new SetAliLink(plugin.getConfig(), linkList, linkData));

	}
	@SuppressWarnings("unchecked")
	private List<Link> MapToLinkList(List<Map<?, ?>> mapList, Server server) {
		List<Link> linkList = new ArrayList<Link>();
		for (Map<?, ?> MapWithLinkData : mapList){
			linkList.add(new Link((Map<String,String>) MapWithLinkData, server));
		}
		return linkList;
	}
}
