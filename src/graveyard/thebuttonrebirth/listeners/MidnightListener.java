package graveyard.thebuttonrebirth.listeners;

import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import graveyard.thebuttonrebirth.ButtonRebirthPlugin;
import graveyard.thebuttonrebirth.tasks.CheckChestTask;


public class MidnightListener implements Listener{
	private final ButtonRebirthPlugin plugin;
	public BukkitTask checkChestTask;
	
	public MidnightListener(ButtonRebirthPlugin initPlugin){
		plugin = initPlugin;
		
		checkChestTask = new CheckChestTask(this.plugin).runTaskTimer(this.plugin, 20, 60);
	}
}
