package buttondevteam.alipresents.components.spawn.cows;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CowSpawnLoop extends BukkitRunnable implements Listener{

	private JavaPlugin plugin;

	public CowSpawnLoop(JavaPlugin plugin) {
		this.plugin = plugin;
		this.runTaskTimer(plugin, 30200, 30200);
	}
	
	@Override
	public void run() {
		boolean foodTrue;
		for (Player player : plugin.getServer().getOnlinePlayers()){
			foodTrue = false;
			for (Entity entity : player.getNearbyEntities(128, 128, 128)){
				if (entity instanceof Cow){
					foodTrue = true;
				}
			}
			if (foodTrue){
				Location location = player.getLocation().add(new Vector(Math.random()*20, 0, Math.random()*20).normalize().multiply(30));
				Block attemptedCowSpawn = player.getWorld().getHighestBlockAt(location);
				if (attemptedCowSpawn.getType().equals(Material.GRASS)){
					player.getWorld().spawnEntity(attemptedCowSpawn.getLocation().add(new Vector (0,1,0)), EntityType.COW);
					player.getWorld().spawnEntity(attemptedCowSpawn.getLocation().add(new Vector (0,1,0)), EntityType.COW);
					player.getWorld().spawnEntity(attemptedCowSpawn.getLocation().add(new Vector (0,1,0)), EntityType.COW);
				}
			}
		}
		
	}

}
