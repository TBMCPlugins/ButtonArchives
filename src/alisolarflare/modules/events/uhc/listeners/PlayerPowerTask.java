package alisolarflare.modules.events.uhc.listeners;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This is the main class that creates and implemnts Ghostie powers
 * When run, it will apply the right potion effects to different players
 * based on what colours they identify as in that time.
 * @author Alisolarflare
 *
 */
public class PlayerPowerTask extends BukkitRunnable{
	private JavaPlugin plugin;
	public PlayerPowerTask(JavaPlugin plugin){
		this.plugin = plugin;
	}
	@Override
	public void run() {
		
	}


}
