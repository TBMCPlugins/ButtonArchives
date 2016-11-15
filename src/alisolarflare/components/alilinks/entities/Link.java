package alisolarflare.components.alilinks.entities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.alilinks.tasks.UnpressTask;

public class Link{
	public String frequency;
	public World world;
	public int x;
	public int y;
	public int z;
	
	public Link (String frequency, World world, int x, int y, int z){
		this.frequency = frequency;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Link(String frequency, Location location, Server server){
		this.frequency = frequency;
		this.world = server.getWorld(location.getWorld().getName());
		this.x = location.getBlockX();
		this.y = location.getBlockY();
		this.z = location.getBlockZ();
		//plugin.plugin.getConfig().set("frequency", 10);
	}
	
	public Link(Map<String,String> linkFromMap, Server server){
		this.frequency = linkFromMap.get("frequency");
		this.world = server.getWorld(linkFromMap.get("world"));
		this.x = Integer.parseInt(linkFromMap.get("x"));
		this.y = Integer.parseInt(linkFromMap.get("y"));
		this.z = Integer.parseInt(linkFromMap.get("z"));
	}
	
	/**
	 * Activates the Ali-Link
	 * @param plugin
	 */
	public void press(JavaPlugin plugin) {
		Location location = new Location(this.world, this.x, this.y, this.z);
		location.getBlock().setType(Material.REDSTONE_BLOCK);
		new UnpressTask(location).runTaskTimer(plugin, 2, 1);
	}
	
	public Map<String,String> toMap(){
		Map<String, String> linkAsMap = new HashMap<String,String>();
		
		linkAsMap.put("frequency", frequency);
		linkAsMap.put("world", world.getName());
		linkAsMap.put("x", Integer.toString(this.x));
		linkAsMap.put("y", Integer.toString(this.y));
		linkAsMap.put("z", Integer.toString(this.z));
		
		return linkAsMap;
	}
}
