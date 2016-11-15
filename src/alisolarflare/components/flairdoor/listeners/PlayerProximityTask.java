package alisolarflare.components.flairdoor.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.components.flairdoor.FlairDoorComponent;

public class PlayerProximityTask extends BukkitRunnable{
	private JavaPlugin plugin;
	private FlairDoorComponent component;
	private Location startLocation;
	private Location endLocation;
	
	public PlayerProximityTask(JavaPlugin plugin, FlairDoorComponent component) {
		this.plugin = plugin;
		this.component = component;
		this.startLocation = component.startLocation;
		this.endLocation = component.endLocation;
	}

	@Override
	public void run() {
		if (startLocation == null || endLocation == null){
			return;
		}
		int sX = startLocation.getBlockX();
		int sY = startLocation.getBlockY();
		int sZ = startLocation.getBlockZ();
		int eX = endLocation.getBlockX();
		int eY = endLocation.getBlockY();
		int eZ = endLocation.getBlockZ();
		int playerX;
		int playerY;
		int playerZ;
		for (Player player : plugin.getServer().getOnlinePlayers()){
			playerX = player.getLocation().getBlockX();
			playerY = player.getLocation().getBlockY();
			playerZ = player.getLocation().getBlockZ();
			if(player.getLocation().getWorld() != startLocation.getWorld())
				continue;
			if((playerX < sX && playerX < eX) ||(playerX > sX && playerX > eX))
				continue;
			if((playerY < sY && playerY < eY) ||(playerY > sY && playerY > eY))
				continue;
			if((playerZ < sZ && playerZ < eZ) ||(playerZ > sZ && playerZ > eZ))
				continue;
			component.playersToBeFlaired.add(player);
			
		}
	}
	
}
