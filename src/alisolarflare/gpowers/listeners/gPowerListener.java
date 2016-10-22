package alisolarflare.gpowers.listeners;

import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import alisolarflare.AliPresents;

public class gPowerListener implements Listener{
	private AliPresents plugin;
	public gPowerApplyingTask powerRepeatingTask;
	public BukkitTask bukkitTask;
	public gPowerListener(AliPresents plugin){
		this.plugin = plugin;
		this.powerRepeatingTask = new gPowerApplyingTask(this.plugin);
		bukkitTask = powerRepeatingTask.runTaskTimer(plugin, 5, 5);
	}
		
}
/*
 * public class CyclicalDisplayListener implements Listener{
	private final ButtonRebirthPlugin plugin;
	public CyclicalDisplayTask cyclicalDisplayTask;
	public BukkitTask bukkitTask;
	
	public CyclicalDisplayListener (ButtonRebirthPlugin initPlugin){
		plugin = initPlugin;
		cyclicalDisplayTask = new CyclicalDisplayTask (this.plugin);
		bukkitTask = cyclicalDisplayTask.runTaskTimer(this.plugin, 20, 20);
	}
}
 */