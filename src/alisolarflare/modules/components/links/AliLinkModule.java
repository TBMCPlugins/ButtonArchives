package alisolarflare.tools.links;
import java.util.List;

import alisolarflare.AliPresents;
import alisolarflare.tools.links.commands.PressAliLink;
import alisolarflare.tools.links.commands.SetAliLink;
import alisolarflare.tools.links.entities.Link;

public class AliLinkSubPlug{
	public AliPresents plugin;
	private SetAliLink setAliLink;
	
	public AliLinkSubPlug(AliPresents plugin){
		this.plugin = plugin;
		
		
	}
	public void register(){
		setAliLink = new SetAliLink(this.plugin);
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
