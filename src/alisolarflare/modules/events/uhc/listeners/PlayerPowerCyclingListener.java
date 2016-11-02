package alisolarflare.modules.events.uhc.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * Main launcher for the repeating task that activates the
 * ghostie powers if an Ultrahardcore Match is going on,
 * and it's time for powers to activate
 */
public class PlayerPowerCyclingListener implements Listener {
	public BukkitTask PowerCyclingTask;
	
	public PlayerPowerCyclingListener(JavaPlugin plugin){
		PowerCyclingTask = (new PlayerPowerTask(plugin)).runTaskTimer(plugin, 20, 20);
	}
}
