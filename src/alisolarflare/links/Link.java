package alisolarflare.links;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.Material;

public class Link implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AliLinkSubPlug subplugin;
	String frequency;
	String world;
	Location location;
	int x;
	int y;
	int z;
	
	
	public Link(AliLinkSubPlug plugin, String frequency, Location location){
		this.frequency = frequency;
		this.location = location;
		this.subplugin = plugin;
		plugin.plugin.getConfig().set("frequency", 10);
	}
	public void press() {
		location.getBlock().setType(Material.REDSTONE_BLOCK);
		UnpressTask unPressTask = new UnpressTask(location);
		unPressTask.runTaskTimer(subplugin.plugin, 2, 1);
	}
}
