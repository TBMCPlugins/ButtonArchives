package alisolarflare.autouhc.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * Main launcher for the repeating task that activates the
 * ghostie powers if an Ultrahardcore Match is going on,
 * and it's time for powers to activate
 */
public class MatchCyclingListener implements Listener {
	public BukkitTask PowerCyclingTask;
	
	public MatchCyclingListener(JavaPlugin plugin){
		PowerCyclingTask = (new MatchMainLoop()).runTaskTimer(plugin, 20, 20);
	}
}
