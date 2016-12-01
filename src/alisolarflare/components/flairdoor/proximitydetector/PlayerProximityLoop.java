package alisolarflare.components.flairdoor.proximitydetector;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.components.flairdoor.FlairDoorComponent;

public class PlayerProximityLoop extends BukkitRunnable implements Listener{
	private static JavaPlugin plugin;
	private static FlairDoorComponent component;
	private static Location startLocation;
	private static Location endLocation;
	
	private static int sX;
	private static int sY;
	private static int sZ;
	private static int eX;
	private static int eY;
	private static int eZ;
	
	public PlayerProximityLoop(JavaPlugin plugin, FlairDoorComponent component) {
		PlayerProximityLoop.plugin = plugin;
		PlayerProximityLoop.component = component;
		this.runTaskTimer(plugin, 0, 20);
	}
	public static void setStartLocation(Location location){
		PlayerProximityLoop.sX = location.getBlockX();
		PlayerProximityLoop.sY = location.getBlockY();
		PlayerProximityLoop.sZ = location.getBlockZ();
		PlayerProximityLoop.startLocation = location;
		PlayerProximityLoop.endLocation.setWorld(location.getWorld());
	}
	public static void setEndLocation(Location location){
		PlayerProximityLoop.eX = location.getBlockX();
		PlayerProximityLoop.eY = location.getBlockY();
		PlayerProximityLoop.eZ = location.getBlockZ();
		PlayerProximityLoop.startLocation.setWorld(location.getWorld());
		PlayerProximityLoop.endLocation = location;
	}

	@Override
	public void run() {
		if (startLocation == null || endLocation == null){
			return;
		}
		int playerX;
		int playerY;
		int playerZ;
		Location playerLocation;
		for (Player player : plugin.getServer().getOnlinePlayers()){
			playerLocation = player.getLocation();
			if(playerLocation.getWorld() != startLocation.getWorld())
				continue;

			playerX = playerLocation.getBlockX();
			if((playerX < sX && playerX < eX) || (playerX > sX && playerX > eX))
				continue;
			playerY = playerLocation.getBlockY();
			if((playerY < sY && playerY < eY) || (playerY > sY && playerY > eY))
				continue;
			playerZ = playerLocation.getBlockZ();
			if((playerZ < sZ && playerZ < eZ) || (playerZ > sZ && playerZ > eZ))
				continue;
			component.playersToBeFlaired.add(player);
			
		}
	}
	
}
