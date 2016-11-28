package alisolarflare.components.flairdoor.proximitydetector;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.components.flairdoor.FlairDoorComponent;

public class PlayerProximityLoop extends BukkitRunnable implements Listener{
	private JavaPlugin plugin;
	private FlairDoorComponent component;
	private Location startLocation;
	private Location endLocation;
	
	private int sX;
	private int sY;
	private int sZ;
	private int eX;
	private int eY;
	private int eZ;
	
	public PlayerProximityLoop(JavaPlugin plugin, FlairDoorComponent component) {
		this.plugin = plugin;
		this.component = component;
		setStartLocation(component.startLocation);
		setEndLocation(component.endLocation);
		this.runTaskTimer(plugin, 0, 20);
	}
	public void setStartLocation(Location location){
		this.sX = startLocation.getBlockX();
		this.sY = startLocation.getBlockY();
		this.sZ = startLocation.getBlockZ();
		this.startLocation = location;
		this.endLocation.setWorld(location.getWorld());
	}
	public void setEndLocation(Location location){
		this.eX = startLocation.getBlockX();
		this.eY = startLocation.getBlockY();
		this.eZ = startLocation.getBlockZ();
		this.endLocation = location;
		this.startLocation.setWorld(location.getWorld());
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
