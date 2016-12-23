package buttondevteam.alipresents.components.dungeons.dungeons;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class GenericDungeonA1 extends Dungeon{
	private Location entrance;
	private Location exit;
	private JavaPlugin plugin;
	
	public GenericDungeonA1(JavaPlugin plugin){
		if(!initDungeon(plugin)){
			plugin.getServer().broadcastMessage("DungeonA1 cant be initialized!");
		}
		this.plugin = plugin;
	}
	private boolean initDungeon(JavaPlugin plugin){
		if (plugin.getServer().getWorld("Dungeons") == null || plugin.getServer().getWorld("world") == null){
			plugin.getServer().broadcastMessage("GenericDungeonA1Error! One of the worlds is null!");
			plugin.getServer().broadcastMessage("Available Worlds... " + plugin.getServer().getWorlds().toString());
			return false;
		}
		
		entrance = new Location(plugin.getServer().getWorld("Dungeons"), -7.5, 138.0, -91.5);
		exit = plugin.getServer().getWorld("world").getSpawnLocation().clone();
		
		if (entrance == null || exit == null){
			plugin.getServer().broadcastMessage("DungeonA1Error! Dungeon Entrance or Exit is null!");
			plugin.getServer().broadcastMessage("Dungeon Entrance: " + entrance.toString());
			plugin.getServer().broadcastMessage("Dungeon Exit: " + exit.toString());
			return false;
		}
		return true;
	}
	public void setEntrance(Location location){
		plugin.getConfig().set("dungeons.dungeona1.entrance", entrance);
		plugin.saveConfig();
		entrance = location;
	}
	public void setExit(Location location){
		exit = location;
	}
	@Override
	public Location getDungeonEntrance() {
		return entrance;
	}
	@Override
	public Location getDungeonExit() {
		return exit;
	}
	
}
