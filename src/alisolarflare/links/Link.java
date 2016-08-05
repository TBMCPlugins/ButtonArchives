package alisolarflare.links;

import org.bukkit.Location;
import org.bukkit.Material;

public class Link {
	static AliLinkSubPlugin plugin;
	String frequency;
	Location location;
	
	public Link(AliLinkSubPlugin plugin, String frequency, Location location){
		this.frequency = frequency;
		this.location = location;
	}
	public void press() {
		location.getBlock().setType(Material.REDSTONE_BLOCK);
		UnpressTask unPressTask = new UnpressTask(location);
		unPressTask.runTaskTimer(plugin.plugin, 2, 1);
	}
}
