package alisolarflare.modules.magictrick.aliarrow;

import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AliArrowTask extends BukkitRunnable{
	JavaPlugin plugin;
	String name;
	Arrow arrow;
	
	
	
	public AliArrowTask(JavaPlugin plugin, Arrow arrow, String name){
		this.name = name;
		this.plugin = plugin;
		this.arrow = arrow;
	}
	
	@Override
	public void run() {
		if (arrow.isOnGround() || arrow.isDead()){
			this.cancel();
		}
		if (name.equalsIgnoreCase("alisolarflare")){
			arrow.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, arrow.getLocation(), 1);
		}
		if (name.equalsIgnoreCase("Zanthr")){
			arrow.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, arrow.getLocation(), 1);
			arrow.getWorld().spawnParticle(Particle.FLAME, arrow.getLocation(), 1);

		}
		
		
		
	}

}
