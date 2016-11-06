package alisolarflare.components.links;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

public class Task_UnpressTask extends BukkitRunnable {
	private Location location;
	public Task_UnpressTask(Location location){
		this.location = location;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		location.getBlock().setType(Material.STAINED_CLAY);
		location.getBlock().setData((byte) 14);
		this.cancel();
	}

}
