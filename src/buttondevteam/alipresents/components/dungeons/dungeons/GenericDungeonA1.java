package buttondevteam.alipresents.components.dungeons.dungeons;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class GenericDungeonA1 extends Dungeon{
	private Location dungeonEntrance;
	private Location dungeonExit;
	
	public GenericDungeonA1(JavaPlugin plugin){
		if(!initDungeon(plugin)){
			plugin.getServer().broadcastMessage("DungeonA1 cant be initialized!");
		}
	}
	private boolean initDungeon(JavaPlugin plugin){
		if (plugin.getServer().getWorld("Dungeons") == null || plugin.getServer().getWorld("world") == null){
			plugin.getServer().broadcastMessage("GenericDungeonA1Error! One of the worlds is null!");
			plugin.getServer().broadcastMessage("Available Worlds... " + plugin.getServer().getWorlds().toString());
			return false;
		}
		
		dungeonEntrance = new Location(plugin.getServer().getWorld("Dungeons"), -7.5, 138.0, -91.5);
		dungeonExit = plugin.getServer().getWorld("world").getSpawnLocation().clone();
		
		if (dungeonEntrance == null || dungeonExit == null){
			plugin.getServer().broadcastMessage("DungeonA1Error! Dungeon Entrance or Exit is null!");
			plugin.getServer().broadcastMessage("DungeonEnterance: " + dungeonEntrance.toString());
			plugin.getServer().broadcastMessage("Dungeon Exit: " + dungeonExit.toString());
			return false;
		}
		return true;
	}
	public void setDungeonEnterance(Location location){
		dungeonEntrance = location;
	}
	@Override
	public Location getDungeonEntrance() {
		return dungeonEntrance;
	}
	@Override
	public Location getDungeonExit() {
		return dungeonExit;
	}
	
}
