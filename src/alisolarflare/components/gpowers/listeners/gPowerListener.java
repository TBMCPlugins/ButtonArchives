package alisolarflare.components.gpowers.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.gpowers.GPowerMemory;

public class gPowerListener implements Listener{
	
	public gPowerListener(JavaPlugin plugin, GPowerMemory gPowerMemory){
		new gPowerApplyingTask(plugin.getServer(), gPowerMemory.poweredPlayerList).runTaskTimer(plugin, 0, 190);
	}		
}