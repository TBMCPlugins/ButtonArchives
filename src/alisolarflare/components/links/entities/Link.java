package alisolarflare.components.links.entities;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.links.tasks.UnpressTask;

public class Link implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String frequency;
	public String world;
	public String x;
	public String y;
	public String z;
	
	
	public Link(String frequency, Location location){
		this.frequency = frequency;
		this.world = location.getWorld().getName();
		this.x = "" + location.getBlockX();
		this.y = "" + location.getBlockY();
		this.z = "" + location.getBlockZ();
		//plugin.plugin.getConfig().set("frequency", 10);
	}
	/**
	 * Activates the Ali-Link
	 * @param plugin
	 */
	public void press(JavaPlugin plugin) {
		Location location = new Location(plugin.getServer().getWorld(world), Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
		location.getBlock().setType(Material.REDSTONE_BLOCK);
		UnpressTask unPressTask = new UnpressTask(location);
		unPressTask.runTaskTimer(plugin, 2, 1);
	}
}
