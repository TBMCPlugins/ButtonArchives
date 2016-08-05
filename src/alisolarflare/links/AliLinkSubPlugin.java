package alisolarflare.links;

import java.util.ArrayList;
import java.util.List;

import alisolarflare.MainPlugin;

public class AliLinkSubPlugin{
	public List<Link> linkList = new ArrayList<Link>();
	public MainPlugin plugin;
	public AliLinkSubPlugin(MainPlugin plugin){
		this.plugin = plugin;
	}
	public void register(){
		plugin.getCommand("pressalilink").setExecutor(new PressAliLink(this));
		plugin.getCommand("setalilink").setExecutor(new SetAliLink(this));
		
	}
	
}
