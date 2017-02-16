package buttondevteam.alipresents.components.alilinks.entities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.components.alilinks.tasks.UnpressTask;

public class Link{
	
	public String frequency;
	public World world;
	public int x;
	public int y;
	public int z;
	
	/**Constructor for copying links*/
	public Link(Link link){
		this.frequency = link.frequency;
		this.world = link.world;
		this.x = link.x;
		this.y = link.y;
		this.z = link.z;
	}
	/**Constructor for deserialization*/
	public Link(Map<String,String> linkFromMap, Server server){
		this.frequency = linkFromMap.get("frequency");
		this.world = server.getWorld(linkFromMap.get("world"));
		this.x = Integer.parseInt(linkFromMap.get("x"));
		this.y = Integer.parseInt(linkFromMap.get("y"));
		this.z = Integer.parseInt(linkFromMap.get("z"));
	}
	/**Constructor for Location inputs*/
	public Link(String frequency, Location location){
		this.frequency = frequency;
		this.world = location.getWorld();
		this.x = location.getBlockX();
		this.y = location.getBlockY();
		this.z = location.getBlockZ();
	}
	/**Pure Constructor*/
	public Link(String frequency, World world, int x, int y, int z){
		this.frequency = frequency;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Activates the Ali-Link
	 * @param plugin
	 */
	public void press(JavaPlugin plugin) {
		Location location = new Location(this.world, this.x, this.y, this.z);
		location.getBlock().setType(Material.REDSTONE_BLOCK);
		new UnpressTask(location).runTaskLater(plugin, 2);
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
