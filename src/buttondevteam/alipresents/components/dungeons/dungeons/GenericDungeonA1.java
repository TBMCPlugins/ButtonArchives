package buttondevteam.alipresents.components.dungeons.dungeons;

import org.bukkit.Location;
import org.bukkit.World;
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
		/*
		if (plugin.getServer().getWorld("Dungeons") == null || plugin.getServer().getWorld("world") == null){
			plugin.getServer().broadcastMessage("GenericDungeonA1Error! One of the worlds is null!");
			plugin.getServer().broadcastMessage("Available Worlds... " + plugin.getServer().getWorlds().toString());
			return false;
		}*/
		if ((entrance = loadLocation(plugin, "dungeons.dungeona1.enter")) == null){
			if(plugin.getServer().getWorld("Dungeons") != null){
				entrance = new Location(plugin.getServer().getWorld("Dungeons"), -7.5, 138.0, -91.5);
			}
		}
		if ((exit = loadLocation(plugin, "dungeons.dungeona1.exit")) == null){
			if (plugin.getServer().getWorld("world") != null){
				exit = plugin.getServer().getWorld("world").getSpawnLocation().clone();
			}
		}
		
		if (entrance == null || exit == null){
			plugin.getServer().broadcastMessage("DungeonA1Error! Dungeon Entrance or Exit is null!");
			plugin.getServer().broadcastMessage("Dungeon Entrance: " + entrance.toString());
			plugin.getServer().broadcastMessage("Dungeon Exit: " + exit.toString());
			return false;
		}
		return true;
	}
	@Override
	public void setEntrance(Location location){
		saveLocation(plugin, "dungeons.dungeona1.enter", location);
		entrance = location;
	}
	@Override
	public void setExit(Location location){
		saveLocation(plugin, "dungeons.dungeona1.exit", location);
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
	private void saveLocation(JavaPlugin plugin, String path, Location location){
		plugin.getConfig().set(path+".world", location.getWorld().getName());
		plugin.getConfig().set(path+".x", location.getX());
		plugin.getConfig().set(path+".y", location.getY());
		plugin.getConfig().set(path+".z", location.getZ());
		plugin.saveConfig();
	}
	private Location loadLocation(JavaPlugin plugin, String path){
		try{
			World world = plugin.getServer().getWorld(plugin.getConfig().getString(path+".world"));
			double x = plugin.getConfig().getDouble(path+".x");
			double y = plugin.getConfig().getDouble(path+".y");
			double z = plugin.getConfig().getDouble(path+".z");
			return new Location(world, x, y, z);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
