package alisolarflare.links;

import java.util.ArrayList;
import java.util.List;

import alisolarflare.AliPresents;

public class AliLinkSubPlug{
	public List<Link> linkList;
	public AliPresents plugin;
	public Serializer serializer;
	public Deserializer deserializer;
	
	public AliLinkSubPlug(AliPresents plugin){
		this.plugin = plugin;
		this.serializer = new Serializer();
		this.deserializer = new Deserializer();
		try{
			this.linkList = deserializer.loadLinkList();
			if(this.linkList == null){
				this.linkList = new ArrayList<Link>();
				serializer.saveLinkList(this.linkList);
			}
		}catch(Exception e){
			linkList = new ArrayList<Link>();
			serializer.saveLinkList(this.linkList);
		}
		
	}
	public void register(){
		plugin.getCommand("pressalilink").setExecutor(new PressAliLink(this));
		plugin.getCommand("setalilink").setExecutor(new SetAliLink(this));
		
	}
	
}
