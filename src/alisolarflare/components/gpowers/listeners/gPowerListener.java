package alisolarflare.components.gpowers.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class gPowerListener implements Listener{
	private JavaPlugin plugin;
	public gPowerApplyingTask powerApplyingTask;
	public BukkitTask bukkitTask;
	
	public gPowerListener(JavaPlugin plugin){
		this.plugin = plugin;
		this.powerApplyingTask = new gPowerApplyingTask(this.plugin);
		bukkitTask = powerApplyingTask.runTaskTimer(plugin, 190, 190);
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