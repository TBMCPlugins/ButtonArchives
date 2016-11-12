package alisolarflare.components.alilinks.entities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.alilinks.tasks.UnpressTask;

public class Link{
	public String frequency;
	public String world;
	public String x;
	public String y;
	public String z;
	
	public Link(Map<String,String> linkFromMap){
		this.frequency = linkFromMap.get("frequency");
		this.world = linkFromMap.get("world");
		this.x = linkFromMap.get("x");
		this.y = linkFromMap.get("y");
		this.z = linkFromMap.get("z");
	}
	
	public Link(String frequency, Location location){
		this.frequency = frequency;
		this.world = location.getWorld().getName();
		this.x = "" + location.getBlockX();
		this.y = "" + location.getBlockY();
		this.z = "" + location.getBlockZ();
		//plugin.plugin.getConfig().set("frequency", 10);
	}
	public Link (String frequency, World world, Double x, Double y, Double z){
		this.frequency = frequency;
		this.world = world.getName();
		this.x = "" + x;
		this.y = "" + y;
		this.z = "" + z;
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
	
	public Map<String,String> toMap(){
		Map<String, String> linkAsMap = new HashMap<String,String>();
		linkAsMap.put("frequency", frequency);
		linkAsMap.put("world", world);
		linkAsMap.put("x", x);
		linkAsMap.put("y", y);
		linkAsMap.put("z", z);
		return linkAsMap;
	}
}
