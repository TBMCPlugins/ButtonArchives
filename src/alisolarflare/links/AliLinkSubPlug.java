package alisolarflare.links;
import java.util.ArrayList;
import java.util.List;

import alisolarflare.AliPresents;
import alisolarflare.links.commands.PressAliLink;
import alisolarflare.links.commands.SetAliLink;
import alisolarflare.links.entities.Link;

public class AliLinkSubPlug{
	public List<Link> linkList = new ArrayList<Link>();
	public AliPresents plugin;
	
	@SuppressWarnings("unchecked")
	public AliLinkSubPlug(AliPresents plugin){
		this.plugin = plugin;
		linkList = (List<Link>) plugin.getConfig().getList("aliLinkList");
		if(linkList == null || linkList.isEmpty()){
			linkList = new ArrayList<Link>();
		}
		
	}
	public void register(){
		plugin.getCommand("pressalilink").setExecutor(new PressAliLink(this));
		plugin.getCommand("setalilink").setExecutor(new SetAliLink(this));
		
	}
	public void saveLinkList(){
		plugin.getConfig().set("aliLinkList", linkList);
	}
	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(){
		return (List<Link>) plugin.getConfig().getList("aliLinkList");
	}
	
}
