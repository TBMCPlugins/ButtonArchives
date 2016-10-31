package alisolarflare.modules.components.links;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.links.commands.PressAliLink;
import alisolarflare.modules.components.links.commands.SetAliLink;
import alisolarflare.modules.components.links.entities.Link;

public class AliLinkModule extends Module{
	public JavaPlugin plugin;
	private SetAliLink setAliLink;
	
	public AliLinkModule(JavaPlugin plugin){
		this.plugin = plugin;
		
		
	}
	@Override
	public void register(JavaPlugin plugin){
		setAliLink = new SetAliLink(plugin);
		plugin.getCommand("setalilink").setExecutor(setAliLink);
		plugin.getCommand("pressalilink").setExecutor(new PressAliLink(this, setAliLink));
		
	}
	public void saveLinkList(){
		plugin.getConfig().set("aliLinkList", setAliLink.linkList);
	}
	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(){
		return (List<Link>) plugin.getConfig().getList("aliLinkList");
	}
	
	
}
